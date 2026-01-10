package pedidos.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pedidos.modelo.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	List<Producto> findByStockLessThan(int cantidad);
	List<Producto> findByCategoriaIdCategoria(int idCategoria);
	List<Producto> findByNombreContaining(String palabraClave);

}
