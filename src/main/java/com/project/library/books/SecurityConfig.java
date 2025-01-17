package com.project.library.books;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Novo formato para desativar CSRF
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());  // Permite todas as requisições

        return http.build();
    }
}

