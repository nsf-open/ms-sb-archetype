#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $lowerCamelCasedPojo = $mainPojo.substring(0,1).toLowerCase() + $mainPojo.substring(1))

package ${groupId}.${artifactIdInLowerCase}.client;

import ${groupId}.${artifactIdInLowerCase}.api.model.${mainPojo};

import org.junit.Assert;
import gov.nsf.components.rest.template.SimpleRestTemplate;
import gov.nsf.components.rest.model.response.ModelResponse;
import gov.nsf.components.rest.authorization.BasicAuthentication;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class ${mainPojo}ServiceClientTest {

	@Autowired
	private ${mainPojo}ServiceClient client;

	private static final String ID_THAT_EXISTS = "12";
	private static final String ID_THAT_DOES_NOT_EXIST = "21";

	@Test
	public void testGet${mainPojo}_HappyPath()  {


		ModelResponse<${mainPojo}> response = client.get${mainPojo}(ID_THAT_EXISTS);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getData());
		Assert.assertEquals(ID_THAT_EXISTS, response.getData().getId());

	}

	@Test
	public void testGet${mainPojo}_NotFound()  {


		ModelResponse<${mainPojo}> response = client.get${mainPojo}(ID_THAT_DOES_NOT_EXIST);

		Assert.assertNotNull(response);
		Assert.assertNull(response.getData());
		Assert.assertNotNull(response.getErrors());
		Assert.assertFalse(response.getErrors().isEmpty());
		Assert.assertEquals(1, response.getErrors().size());
		Assert.assertEquals("Resource Not Found", response.getErrors().get(0).getTitle());

	}

	@Configuration
	static class TestConfiguration {


		@Bean
		public ${mainPojo}ServiceClient ${lowerCamelCasedPojo}ServiceClient( RestTemplate restTemplate ){
			${mainPojo}ServiceClientImpl client = new ${mainPojo}ServiceClientImpl();
			client.setServiceURL("http://localhost:8080/${artifactIdInLowerCase}-service/api/auth");
			client.setAuthorization(new BasicAuthentication("change_me", "change_me"));
			client.setRestTemplate(restTemplate);

			return client;
		}

		@Bean
		public RestTemplate restTemplate( ){
			return new SimpleRestTemplate(60000);
		}
	}
}
