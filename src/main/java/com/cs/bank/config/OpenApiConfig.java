package com.cs.bank.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Bank Management API")
                        .version("v1.0")
                        .description("API Documentation for the Customer and Loan services.")
                        .termsOfService("http://example.com/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                );
    }
}