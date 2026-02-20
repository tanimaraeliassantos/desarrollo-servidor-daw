package seguridad.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import seguridad.model.entity.Incidencia;

public interface IncidenciaRepository extends MongoRepository<Incidencia, String>{
	List<Incidencia> findByCamionId(String camionId);

}
