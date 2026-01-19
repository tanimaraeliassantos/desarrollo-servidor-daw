package seguridad;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import seguridad.model.entity.Usuario;
import seguridad.model.repository.MercanciaRepository;
import seguridad.model.repository.UsuarioRepository;

@SpringBootApplication
public class TanimaraEliassantosActividad2Application {

    public static void main(String[] args) {
        SpringApplication.run(TanimaraEliassantosActividad2Application.class, args);
    }

    // --- ESTO ES LO QUE HACE QUE FUNCIONE ---
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "logistica_bbdd");
    }

    @Bean
    CommandLineRunner initData(UsuarioRepository repo) {
        return args -> {          
            String emailPrueba = "empresa9@test.com";
            if (repo.findByEmail(emailPrueba).isEmpty()) {
                Usuario u = new Usuario();
                u.setEmail(emailPrueba);
                u.setPassword("{noop}1234");
                u.setRol("CONDUCTOR");
                repo.save(u);
                System.out.println(">>> USUARIO CREADO");
            } else {
                System.out.println(">>> EL USUARIO YA EXISTÍA");
            }
            
            System.out.println(">>> CONEXIÓN VERIFICADA. TOTAL USUARIOS: " + repo.count());
        
            
        };
    }
}