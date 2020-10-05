#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.${artifactIdInLowerCase};

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"${groupId}.${artifactIdInLowerCase}"})
public class ${mainPojo}ServiceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(${mainPojo}ServiceApplication.class);
    }

    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/${artifactIdInLowerCase}-service/api");
        setEmbeddedContainerEnvironmentProperties();
        SpringApplication.run(${mainPojo}ServiceApplication.class, args);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        setExternalContainerEnvironmentProperties();
        super.onStartup(servletContext);
    }

    private static void setEmbeddedContainerEnvironmentProperties() {
        setEnvironmentProperties();
        System.setProperty("server.context-path", "/${artifactIdInLowerCase}-service/api");
    }

    private static void setExternalContainerEnvironmentProperties() {
        setEnvironmentProperties();
    }

    private static void setEnvironmentProperties() {
        System.setProperty("spring.config.name", "${artifactIdInLowerCase}-service");
    }

}
