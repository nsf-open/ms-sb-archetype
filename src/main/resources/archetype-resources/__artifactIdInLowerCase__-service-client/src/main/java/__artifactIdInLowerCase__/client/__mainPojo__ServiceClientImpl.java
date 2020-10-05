#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $lowerCamelCasedPojo = $mainPojo.substring(0,1).toLowerCase() + $mainPojo.substring(1))

package ${groupId}.${artifactIdInLowerCase}.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gov.nsf.components.rest.client.NsfRestClient;
import gov.nsf.components.rest.extractor.JsonPathInfo;
import gov.nsf.components.rest.extractor.ModelResponseExtractor;
import gov.nsf.components.rest.model.response.ModelResponse;
import gov.nsf.components.rest.util.NsfRestUtils;
import ${groupId}.${artifactIdInLowerCase}.client.exception.${mainPojo}ServiceClientException;
import java.util.Collections;
import org.springframework.http.HttpHeaders;



import org.springframework.http.HttpMethod;

import ${groupId}.${artifactIdInLowerCase}.client.${mainPojo}ServiceClient;
import ${groupId}.${artifactIdInLowerCase}.api.model.${mainPojo};

public class ${mainPojo}ServiceClientImpl extends NsfRestClient implements ${mainPojo}ServiceClient {

    private String serviceURL;

    @Override
    public ModelResponse<${mainPojo}> get${mainPojo}(String id) {

        String url = serviceURL + "/${lowerCamelCasedPojo}s/{id}";
        try {
            return executeRequest(
                url,
                HttpMethod.GET,
                Collections.singletonMap("id", id),
                new ModelResponseExtractor<${mainPojo}>(${mainPojo}.class, new JsonPathInfo(null, "${lowerCamelCasedPojo}"))
            );
        } catch (Exception ex) {
            throw new ${mainPojo}ServiceClientException(ex);
        }
    }

    @Override
    public ModelResponse<${mainPojo}> create${mainPojo}(${mainPojo} $lowerCamelCasedPojo) {
        String url = serviceURL + "/${lowerCamelCasedPojo}s";

        try {
            return executeRequest(
                url,
                HttpMethod.POST,
                json($lowerCamelCasedPojo),
                new ModelResponseExtractor<${mainPojo}>(${mainPojo}.class, new JsonPathInfo(null, "${lowerCamelCasedPojo}"))
            );
        } catch (Exception ex) {
            throw new ${mainPojo}ServiceClientException(ex);
        }
    }

    @Override
    public ModelResponse<${mainPojo}> update${mainPojo}(${mainPojo} $lowerCamelCasedPojo) {
        String url = serviceURL + "/${lowerCamelCasedPojo}s/{id}";

        try {
            return executeRequest(
                url,
                HttpMethod.PUT,
                new HttpHeaders(),
                json($lowerCamelCasedPojo),
                Collections.singletonMap("id", ${lowerCamelCasedPojo}.getId()),
                new ModelResponseExtractor<${mainPojo}>(${mainPojo}.class, new JsonPathInfo(null, "${lowerCamelCasedPojo}"))
            );
        } catch (Exception ex) {
            throw new ${mainPojo}ServiceClientException(ex);
        }

    }

    @Override
    public ModelResponse<${mainPojo}> delete${mainPojo}(String id) {

        String url = serviceURL + "/${lowerCamelCasedPojo}s/{id}";
        try {
            return executeRequest(
                url,
                HttpMethod.DELETE,
                Collections.singletonMap("id", id),
                new ModelResponseExtractor<${mainPojo}>(${mainPojo}.class, new JsonPathInfo(null, "${lowerCamelCasedPojo}"))
            );
        } catch (Exception ex) {
            throw new ${mainPojo}ServiceClientException(ex);
        }
    }

    private String json(Object object) {

        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Failed to convert object to json");
        }
    }

    public String getServiceURL() {
        return serviceURL;
    }

    public void setServiceURL(String serviceURL) {
        this.serviceURL = serviceURL;
    }

}
