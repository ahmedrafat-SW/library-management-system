package com.dev.librarymanagementsystem.config.web;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        Contact contact = new Contact();
        contact.email("ahmed.rafat.abdelbar@gmail.com");
        return new OpenAPI()
                .info(new Info().title("Library Management api ").contact(contact).version("v1"));
    }
}
