package com.example.student.config;

import com.example.student.security.JwtAuthenticationFilter;
import com.example.student.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService){
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        JwtAuthenticationFilter jwtFilter = new JwtAuthenticationFilter(customUserDetailsService);

        http
                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(auth ->auth

                        // PUBLIC ENDPOINTS
                        .requestMatchers(
                                "/api/auth/**",
                                "/swagger-ui/**",
                                "/v3/api-docs/**"
                        ).permitAll()

                        // ROLE-BASED RULE
                        .requestMatchers(HttpMethod.DELETE, "/api/students/")
                        .hasRole("ADMIN")

                        // AUTHENTICATED USERS
                        .requestMatchers("/api/**")
                        .authenticated()

                        //Everything Else
                        .anyRequest().denyAll())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config ) throws Exception{
        return config.getAuthenticationManager();
    }

}
