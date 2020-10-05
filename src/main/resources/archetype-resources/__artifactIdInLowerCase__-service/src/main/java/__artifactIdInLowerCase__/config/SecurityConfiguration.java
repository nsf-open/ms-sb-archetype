#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.${artifactIdInLowerCase}.config;

import gov.nsf.components.rest.model.message.NsfResponseMessage;
import gov.nsf.components.rest.model.message.Source;
import gov.nsf.components.rest.model.response.BaseResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Configuration
    @EnableWebSecurity
    @ConditionalOnProperty(value = "security.basic.enabled", havingValue = "true")
    public static class BasicAuthConfiguration extends WebSecurityConfigurerAdapter {

        @Value("${security.basic.user.name}")
        private String username;

        @Value("${security.basic.user.password}")
        private String password;

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.antMatcher("/auth/**").authorizeRequests().anyRequest().authenticated().and()
                    .httpBasic().authenticationEntryPoint(authEntryPoint()).and().sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();
        }


        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser(username).password("{noop}" + password).roles("SERVICE");
        }


        @Bean
        public AuthenticationEntryPoint authEntryPoint() {
            return new AuthenticationEntryPoint() {
                @Override
                public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) throws IOException, ServletException {
                    NsfResponseMessage error = new NsfResponseMessage();

                    error.setTitle("Unauthorized");
                    error.setDescription(authenticationException.getMessage());
                    error.setHttpStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    error.setCode(null);
                    error.setSource(new Source(request.getRequestURI()));

                    BaseResponse baseResponse = new BaseResponse();
                    baseResponse.addError(error);

                    response.setContentType("application/json");
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getOutputStream().println(baseResponse.toString());
                    response.addHeader("WWW-Authenticate", "Basic realm=" + request.getServerName());
                }
            };
        }

    }
}