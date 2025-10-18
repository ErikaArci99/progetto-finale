package org.lessons.java.progetto_finale.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    private final DatabaseUserDetailsService userDetailsService;

    public SecurityConfiguration(DatabaseUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // rendi pubbliche le API per React
                        .requestMatchers("/api/**").permitAll()

                        // risorse pubbliche e pagina di login
                        .requestMatchers("/css/**").permitAll()

                        // solo ADMIN può creare, modificare o eliminare
                        .requestMatchers("/borse/create", "/borse/edit/**", "/borse/delete/**").hasRole("ADMIN")
                        .requestMatchers("/collezioni/create", "/collezioni/edit/**", "/collezioni/delete/**")
                        .hasRole("ADMIN")
                        .requestMatchers("/sconti/create", "/sconti/edit/**", "/sconti/delete/**").hasRole("ADMIN")
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        // USER e ADMIN possono solo visualizzare
                        .requestMatchers("/", "/borse/list", "/collezioni/list", "/sconti/list", "/borse/details/**",
                                "/collezioni/details/**", "/sconti/details/**")
                        .hasAnyRole("USER", "ADMIN")

                        // tutto il resto richiede autenticazione
                        .anyRequest().authenticated())

                // login e impostazioni di sicurezza
                .formLogin(form -> form
                        .defaultSuccessUrl("/borse", true) // pagina di default dopo il login
                )

                // disattiva CSRF solo per le API REST
                .csrf(csrf -> csrf.ignoringRequestMatchers("/api/**"))

                // abilita CORS (necessario per React)
                .cors(cors -> {
                })

                .userDetailsService(userDetailsService);

        return http.build();
    }
}
