package seguridad.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.AbstractPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import seguridad.model.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable())
            .authorizeHttpRequests(auth -> auth
            	.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()	
            	.requestMatchers("/login", "/registro", "/").permitAll()
            	.requestMatchers("/api/mercancias/crear").hasRole("EMPRESA")
                .requestMatchers("/api/mercancias/disponibles").hasAnyRole("EMPRESA", "CONDUCTOR")
                .requestMatchers("/api/mercancias/buscar").hasAnyRole("EMPRESA", "CONDUCTOR")
                .requestMatchers("/api/inscripciones/apuntarse").hasRole("CONDUCTOR")
                .requestMatchers("/api/incidencias/**").hasRole("CONDUCTOR")
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults());
            
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
