package es.agrobook.api.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI customOpenAPI() {

        return new OpenAPI().components(new Components()).info(new Info()
                .title("REST Agrobook backend Api Documentation").version("1.0")
                .termsOfService("Agrobook backend terms of service")
                .description(
                        "This is REST API documentation of the Agrobook backend.")
                .license(swaggerLicense()).contact(swaggerContact()));
    }

    private Contact swaggerContact() {
        Contact agroboookContact = new Contact();
        agroboookContact.setName("Enrique Chamber");
        agroboookContact.setEmail("kike98chgq@gmail.com");
        agroboookContact.setUrl("https://github.com/EnriqueChamber/Agrobook-Resource-Server");
        return agroboookContact;
    }

    private License swaggerLicense() {
        License agrobookLicense = new License();
        agrobookLicense.setName("Creative Commons Attribution 4.0 International");
        agrobookLicense.setUrl("https://creativecommons.org/licenses/by/4.0/");
        agrobookLicense.setExtensions(Collections.emptyMap());
        return agrobookLicense;
    }

}
