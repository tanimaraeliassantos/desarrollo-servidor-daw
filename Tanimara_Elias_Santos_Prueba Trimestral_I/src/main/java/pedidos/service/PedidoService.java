package pedidos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pedidos.modelo.entities.Pedido;
import pedidos.modelo.entities.Usuario;

@Service
public interface PedidoService {
	Usuario buscarUsuarioPorIdPedido(int idPedido);
	List<Usuario> buscarUsuariosConPedidos();
	List<Pedido> buscarPedidosConMasDe(int cantidadLineas);
}
