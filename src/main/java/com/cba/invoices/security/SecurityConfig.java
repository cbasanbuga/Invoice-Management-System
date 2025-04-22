package com.cba.invoices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager detailsManager (DataSource dataSource){
        // Özelleştirilmiş bir tablo kullanmayacağım şuan için. Spring'in istediği mevcut yapıyı kullanacağım.
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.authorizeHttpRequests(config -> config
                .requestMatchers(HttpMethod.POST, "api/customers").hasRole("MANAGER")
                .requestMatchers(HttpMethod.POST, "api/invoices").hasAnyRole("MANAGER", "USER")
                .requestMatchers(HttpMethod.GET, "api/invoices/**").hasAnyRole("MANAGER", "USER")

        );
        security.csrf(AbstractHttpConfigurer::disable);
        security.httpBasic(Customizer.withDefaults());
        return security.build();
    }

    /*
    #
    # Basic Auth için kullanıcı ve rolleri DB üzerinden çekeceğim için burayı kapattım.
    #

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails cba = User.builder()
                .username("Batuhan")
                .password("{noop}123")
                .roles("USER")
                .build();

        UserDetails hba = User.builder()
                .username("Han")
                .password("{noop}456")
                .roles("USER", "MANAGER")
                .build();

        return new InMemoryUserDetailsManager(cba, hba);

    }*/
}
