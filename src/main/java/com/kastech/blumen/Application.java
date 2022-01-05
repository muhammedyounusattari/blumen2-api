/*
 * ***************************************************************
 *  Copyright (c) Optum, Inc 2018.
 *  This software and documentation contain confidential and
 *  proprietary information owned by Optum, Inc.
 *  Unauthorized use and distribution are prohibited.
 * **************************************************************
 */
package com.kastech.blumen;

import com.kastech.blumen.config.PathBasedConfigResolver;
import org.keycloak.adapters.KeycloakConfigResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.kastech.blumen.repository.*")
@ComponentScan(value = {"com.kastech.blumen.*"})
@EnableTransactionManagement
@EnableSwagger2
@PropertySource(value = "classpath:application.properties")

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Required to handle spring boot configurations
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(PathBasedConfigResolver.class)
    public KeycloakConfigResolver keycloakConfigResolver() {
        return new PathBasedConfigResolver();
    }
}
