package seguridad.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import seguridad.model.entity.Camion;

public interface CamionRepository extends MongoRepository<Camion, String> {
	List<Camion> findByConductorId(String conductorId);
	List<Camion> findByEstado(String estado);
	

}
