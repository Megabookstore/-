package com.bookstore_member.megabookstore_member.security;

import com.bookstore_member.megabookstore_member.domain.member.Role;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Log4j2
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> {
            auth.antMatchers("/normals").hasRole("USER");
            auth.antMatchers("/admins").hasRole("ADMIN");
        });

        http.formLogin();

        return http.build();

    }
}
