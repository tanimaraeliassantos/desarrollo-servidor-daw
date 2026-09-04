package seguridad.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import seguridad.model.entity.Inscripcion;

public interface InscripcionRepository extends MongoRepository<Inscripcion, String>{
	List<Inscripcion> findByMercanciaId(String mercanciaId);
	List<Inscripcion> findByCamionId(String camionId);
	
}
