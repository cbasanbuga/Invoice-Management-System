package com.cba.invoices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails cba = User.builder()
                .username("Batuhan")
                .password("{noop}123")
                .roles("USER")
                .build();

        UserDetails hba = User.builder()
                .username("Batuhan2")
                .password("{noop}456")
                .roles("USER", "MANAGER")
                .build();

        return new InMemoryUserDetailsManager(cba, hba);


        //asd
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.authorizeHttpRequests(config -> config
                .requestMatchers(HttpMethod.POST, "api/customers").hasRole("MANAGER")
                .requestMatchers(HttpMethod.POST, "api/invoices").hasAnyRole("MANAGER", "USER")  // tek seviye için
                .requestMatchers(HttpMethod.GET, "api/invoices/**").hasAnyRole("MANAGER", "USER") // alt path'ler için

        );
        security.csrf(AbstractHttpConfigurer::disable);
        security.httpBasic(Customizer.withDefaults());
        return security.build();
    }
}
