package seguridad.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.AbstractPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import seguridad.model.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
		.csrf(csrf -> csrf.disable())
		.sessionManagement(ses -> ses.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.cors(Customizer.withDefaults())
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/login", "/registro", "/").permitAll()
				.requestMatchers("/api/mercancias/crear").hasRole("EMPRESA")
				.requestMatchers("/api/inscripciones/apuntarse").hasRole("CONDUCTOR")
				.requestMatchers("/api/incidencias/**").hasRole("CONDUCTOR")
				.requestMatchers("/api/mercancias/disponibles").hasAnyRole("CONDUCTOR", "EMPRESA")
				.requestMatchers("/api/mercancias/buscar").hasAnyRole("CONDUCTOR", "EMPRESA")
				
				.anyRequest().authenticated())
		.userDetailsService(customUserDetailsService)
		.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return org.springframework.security.crypto.factory.PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	

}
