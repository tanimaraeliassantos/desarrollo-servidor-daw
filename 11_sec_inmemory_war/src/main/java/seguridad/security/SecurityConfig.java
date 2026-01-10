package seguridad.security;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	@Bean
	public InMemoryUserDetailsManager usersdetails() throws Exception{
		List<UserDetails> users=List.of(
		User
		.withUsername("user1")
		//.password("$2a$12$YUq1fO2Vbz.ONbIo./xmBeGCYFr5m4OLNC8H9HFafn4fpcOnUbqda")
		.password("{noop}user1")
		.roles("USERS")
		.build(),
		User
		.withUsername("user2")
		.password("{noop}user2")
		.roles("OPERATOR")
		.build());
	 
		return new InMemoryUserDetailsManager(users);
	}
}
