package com.mstSimulator.MST.Example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for testing purposes
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/mst").permitAll() // Allow all access to /api/mst
                .anyRequest().authenticated() // All other requests require authentication
            );
        return http.build();
    }
}
