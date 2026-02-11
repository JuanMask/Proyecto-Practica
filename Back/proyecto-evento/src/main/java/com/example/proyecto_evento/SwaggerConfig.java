package com.example.proyecto_evento;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Eventos")
                        .description("los usuarios pueden registrarse a diferentes actividades culturales, deportivas, etc; asi como crear eventos propios.")
                        .version("1.0"));
    }
}