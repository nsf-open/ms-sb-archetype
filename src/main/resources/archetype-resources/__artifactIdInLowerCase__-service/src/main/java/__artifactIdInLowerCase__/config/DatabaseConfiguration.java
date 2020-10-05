#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.${artifactIdInLowerCase}.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DatabaseConfiguration {

    @Configuration
    @EnableTransactionManagement
    @EnableJpaRepositories(
            basePackages = "${groupId}.${artifactIdInLowerCase}.dao.repository.csd",
            entityManagerFactoryRef = "entityManagerCSD",
            transactionManagerRef = "transactionManagerCSD"
    )
    public static class ConfigurationCSD {

        @Bean
        @Primary
        @ConfigurationProperties(prefix = "application.csd")
        public DataSource dataSourceCSD() {
            return DataSourceBuilder.create().build();
        }

        @Bean
        @Primary
        public LocalContainerEntityManagerFactoryBean entityManagerCSD() {
            LocalContainerEntityManagerFactoryBean em
                    = new LocalContainerEntityManagerFactoryBean();
            em.setDataSource(dataSourceCSD());
            em.setPackagesToScan(
                    new String[] { "${groupId}.${artifactIdInLowerCase}.dao.entity.csd" });

            HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
            em.setJpaVendorAdapter(vendorAdapter);

            HashMap<String, Object> properties = new HashMap<>();
            properties.put("hibernate.hbm2ddl.auto", "none");
            properties.put("hibernate.dialect", "org.hibernate.dialect.SybaseDialect");
            em.setJpaPropertyMap(properties);

            return em;
        }

        @Primary
        @Bean
        public PlatformTransactionManager transactionManagerCSD() {

            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(entityManagerCSD().getObject());
            return transactionManager;
        }
    }

    @Configuration
    @EnableTransactionManagement
    @EnableJpaRepositories(
            basePackages = "${groupId}.${artifactIdInLowerCase}.dao.repository.flp",
            entityManagerFactoryRef = "entityManagerFLP",
            transactionManagerRef = "transactionManagerFLP"
    )
    public static class ConfigurationFLP {

        @Bean
        @ConfigurationProperties(prefix = "application.flp")
        public DataSource dataSourceFLP() {
            return DataSourceBuilder.create().build();
        }

        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFLP() {
            LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
            em.setDataSource(dataSourceFLP());
            em.setPackagesToScan(
                    new String[] { "${groupId}.${artifactIdInLowerCase}.dao.entity.flp" });

            HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
            em.setJpaVendorAdapter(vendorAdapter);

            HashMap<String, Object> properties = new HashMap<>();
            properties.put("hibernate.hbm2ddl.auto", "none");
            properties.put("hibernate.dialect", "org.hibernate.dialect.SybaseDialect");

            em.setJpaPropertyMap(properties);

            return em;
        }

        @Bean
        public PlatformTransactionManager transactionManagerFLP() {

            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(entityManagerFLP().getObject());
            return transactionManager;
        }
    }

}
