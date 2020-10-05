#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.${artifactIdInLowerCase}.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("${groupId}.${artifactIdInLowerCase}.controller"))              
          .paths(PathSelectors.any())
          .build()
          .apiInfo(apiInfo())
          .useDefaultResponseMessages(false);
    }
    
    private static ApiInfo apiInfo() {
        return new ApiInfo(
          "${artifactIdInUpperCase} API",
          "Documentation describing RESTful endpoints hosted by the ${artifactIdInUpperCase}",
          "v 0.0.1-SNAPSHOT",
          null,
          new Contact("Development Team", null, "yourdevteam@nsf.gov"),
          null,
          null);
    }
    
}
