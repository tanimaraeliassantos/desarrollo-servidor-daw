package seguridad;

import java.util.Collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import seguridad.model.entity.Usuario;
import seguridad.model.repository.UsuarioRepository;

@SpringBootApplication
public class Actividad2TanimaraEliasSantosApplication {

	public static void main(String[] args) {

        SpringApplication.run(
            Actividad2TanimaraEliasSantosApplication.class, args
        );
 
    }
	
	@Bean
	CommandLineRunner initData(UsuarioRepository repo) {
	    return args -> {
	        repo.deleteAll();
	        Usuario u = new Usuario();
	        u.setEmail("empresa6@test.com");
	        u.setPassword("{noop}1234");
	        u.setRol("EMPRESA");
	        repo.save(u);
	        System.out.println(">>> USUARIO DE PRUEBA CREADO EN MONGODB");
	    };
	}

}
