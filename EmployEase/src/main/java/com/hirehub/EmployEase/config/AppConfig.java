package com.hirehub.EmployEase.config;

import java.util.Arrays;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class AppConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.sessionManagement(management->management
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(Authorize->Authorize
        .requestMatchers("/api/admin/**").hasAnyRole("ADMINISTRATOR","EMPLOYER")
        .requestMatchers("/api/**").authenticated()
        .anyRequest().permitAll()
        ).addFilterBefore(new JWTTokenValidator(), BasicAuthenticationFilter.class)
        .csrf(csrf->csrf.disable())
        .cors(cors->cors.configurationSource(corsConfigurationSource()));
        return http.build();
    }

    private CorsConfigurationSource corsConfigurationSource()
    {
        return new CorsConfigurationSource() {

            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
               CorsConfiguration cfg = new CorsConfiguration();
               cfg.setAllowedOrigins(Arrays.asList(
                "http://localhost:5454",
                "https://employease.hirehub.app",
                "http://localhost:3000"
               ));
                cfg.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Méthodes autorisées
                cfg.setAllowCredentials(true); // Autoriser les cookies
                cfg.setAllowedHeaders(Collections.singletonList("*")); // Tous les en-têtes autorisés
                cfg.setExposedHeaders(Arrays.asList("Authorization")); // Exposer l'en-tête Authorization
                cfg.setMaxAge(3600L); // Durée de mise en cache des options CORS
               return cfg;
            }
        };
    }

    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

}
