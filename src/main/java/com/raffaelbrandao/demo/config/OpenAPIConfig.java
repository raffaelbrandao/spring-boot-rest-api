package com.raffaelbrandao.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Value("${demo.openapi.contact.name}")
    private String contactName;

    @Value("${demo.openapi.contact.email}")
    private String contactEmail;

    @Value("${demo.openapi.contact.url}")
    private String contactUrl;

    @Value("${demo.openapi.licence.name}")
    private String licenceName;

    @Value("${demo.openapi.licence.url}")
    private String licenceUrl;

    @Value("${demo.openapi.info.title}")
    private String title;

    @Value("${demo.openapi.info.description}")
    private String description;

    @Value("${demo.openapi.info.version}")
    private String version;

    @Value("${demo.openapi.info.terms}")
    private String terms;

    @Bean
    public OpenAPI openAPI(){
        Contact contact = new Contact()
                .name(this.contactName)
                .email(this.contactEmail)
                .url(this.contactUrl);

        License license = new License()
                .name(this.licenceName)
                .url(this.licenceUrl);

        Info info = new Info()
                .title(this.title)
                .description(this.description)
                .version(this.version)
                .contact(contact)
                .license(license)
                .termsOfService(this.terms);

        return new OpenAPI().info(info);
    }
}
