package com.hirehub.user.microservice.alluser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Remplace "*" par le domaine spécifique si nécessaire
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
