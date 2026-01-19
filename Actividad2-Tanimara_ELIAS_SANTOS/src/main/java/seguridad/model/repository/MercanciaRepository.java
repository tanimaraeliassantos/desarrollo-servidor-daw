package seguridad.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import seguridad.model.entity.Mercancia;

public interface MercanciaRepository extends MongoRepository<Mercancia, String>{
	List<Mercancia> findByEstado(String estado);
	
	List<Mercancia> findByOrigenOrDestino(String origen, String destino);

}
