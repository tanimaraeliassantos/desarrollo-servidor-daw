package pedidos.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pedidos.modelo.entities.Pedido;
import pedidos.modelo.entities.Usuario;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	@Query("SELECT DISTINCT p.usuario FROM Pedido p")
	List<Usuario> findUsuariosWithPedidos();
	@Query("SELECT p FROM Pedido p JOIN p.lineas lp GROUP BY p.idPedido HAVING COUNT(lp) > ?1")
	List <Pedido> findPedidosConMasdeLineas(int cantidadLineas);

}
