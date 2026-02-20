package seguridad.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import seguridad.model.entity.Mercancia;

public interface MercanciaRepository extends MongoRepository<Mercancia, String>{
	List<Mercancia> findByEstado(String estado);
	List<Mercancia> findByOrigenIgnoreCaseOrDestinoIgnoreCase(String origen, String destino);
	//Añadido para prueba trimestral
	Long countByEstado(String estado);
	List<Mercancia> findByDistanciaKmGreaterThan(Double distancia);
}
