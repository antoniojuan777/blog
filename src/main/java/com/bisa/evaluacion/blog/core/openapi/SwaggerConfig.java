package com.bisa.evaluacion.blog.core.openapi;

import java.util.List;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenApiCustomizer sortTags() {
        return openApi -> {
            if (openApi.getTags() != null) {

                // Orden deseado
                List<String> orderedNames = List.of(
                        "Autores",
                        "Blogs",
                        "Comentarios");

                openApi.setTags(orderedNames.stream()
                        .map(name -> new Tag().name(name))
                        .toList());
            }
        };
    }
}