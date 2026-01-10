package apirest.empleados.modelo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import apirest.empleados.modelo.collections.Empleado;

public interface EmpleadoRepository extends MongoRepository<Empleado, ObjectId>{
	
	List <Empleado> findByTrabajo_salarioGreaterThan(double salario);

}
