package com.meubronze.app.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
@Log4j2
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .authorizeHttpRequests((http) -> http
//                        .requestMatchers(new AntPathRequestMatcher("/config/post")).hasRole("ADMIN")
//                        .requestMatchers(new AntPathRequestMatcher("/config/put")).hasRole("ADMIN")
//                        .requestMatchers(new AntPathRequestMatcher("/client/post")).hasRole("ADMIN")
//                        .requestMatchers(new AntPathRequestMatcher("/client/put")).hasRole("ADMIN")
//                        .requestMatchers(new AntPathRequestMatcher("/client/delete/**")).hasRole("ADMIN")
//                        .requestMatchers(new AntPathRequestMatcher("/bronze/post")).hasRole("ADMIN")
//                        .requestMatchers(new AntPathRequestMatcher("/bronze/delete")).hasRole("ADMIN")
//                        .requestMatchers(new AntPathRequestMatcher("/config/get")).hasRole("USER")
//                        .requestMatchers(new AntPathRequestMatcher("/client/all")).hasRole("USER")
//                        .requestMatchers(new AntPathRequestMatcher("/bronze/all")).hasRole("USER")
//                        .anyRequest()
//                        .authenticated()
//                )
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults())
//                .csrf(AbstractHttpConfigurer::disable);
//        return httpSecurity.build();
//    }

    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests((http) -> http
                        .anyRequest()
                        .authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable);
        return httpSecurity.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        UserDetails user = User.withUsername("rafael")
//                .password(encoder.encode("rafael"))
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password(encoder.encode("admin"))
//                .roles("USER", "ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        log.info("'rafael' encoded {}", encoder.encode("rafael"));
//        log.info("'admin' encoded {}", encoder.encode("admin"));
        return authenticationConfiguration.getAuthenticationManager();
    }
}
