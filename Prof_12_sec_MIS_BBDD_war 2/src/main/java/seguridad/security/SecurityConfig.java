package seguridad.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	@Bean
	UserDetailsManager usersCustom(DataSource dataSource) {

		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource); 
			users.setUsersByUsernameQuery("select username,password,enabled from Usuarios u where username=?"); 
			users.setAuthoritiesByUsernameQuery("select u.username,p.nombre from Usuario_Perfiles up " +
					"inner join usuarios u on u.username = up.username " +
					"inner join perfiles p on p.id_perfil = up.id_perfil " +
					"where u.username = ?");

			return users;
}
}