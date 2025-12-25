package com.example.student.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI studentOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Student Management Api")
                        .description("Spring Project For Learning from Basic to Advanced")
                        .version("1.0")
                );
    }
}
