package com.orderflow.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Desabilita CSRF para facilitar testes
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll()  // Permite acesso público ao endpoint
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> httpBasic.disable())  // Desabilita autenticação básica
                .formLogin(formLogin -> formLogin.disable());  // Nova forma de desabilitar formLogin

        return http.build();
    }

    @Bean
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

}
