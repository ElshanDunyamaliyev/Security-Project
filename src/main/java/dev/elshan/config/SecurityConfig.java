package dev.elshan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> {
            requests.requestMatchers("/account","/balance","/card","/loan").authenticated();
            requests.requestMatchers("/contact","/notice").permitAll();
        });
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return (SecurityFilterChain)http.build();
    }

    // Butun requestleri deny edir
    // requests.anyRequest().denyAll();
    // Butun requestleri permit edir
    // requests.anyRequest().permitAll();

    @Bean
    InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("12345").authorities("admin").build();
        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("12345").authorities("read").build();
        return new InMemoryUserDetailsManager(admin, user);
    }
}
