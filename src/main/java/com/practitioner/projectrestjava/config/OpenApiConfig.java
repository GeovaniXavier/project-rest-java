package com.practitioner.projectrestjava.config;

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
                        .title("Projeto RestFull")
                        .version("v1")
                        .description("Descrição de um projeto pessoal.")
                        .termsOfService("https://www.linkedin.com/in/geovani-xavier/")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.linkedin.com/in/geovani-xavier/")));
    }
}
