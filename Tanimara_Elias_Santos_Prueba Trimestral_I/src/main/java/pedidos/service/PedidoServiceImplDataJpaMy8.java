package pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pedidos.modelo.entities.Pedido;
import pedidos.modelo.entities.Usuario;
import pedidos.modelo.repository.PedidoRepository;
import pedidos.modelo.repository.UsuarioRepository;

@Service
public class PedidoServiceImplDataJpaMy8 implements PedidoService{
	
	@Autowired
	private PedidoRepository pedidoRepository;


	@Override
	public List<Usuario> buscarUsuariosConPedidos() {
		return pedidoRepository.findUsuariosWithPedidos();
	}

	@Override
	public Usuario buscarUsuarioPorIdPedido(int idPedido) {
		try {
			Pedido pedido = pedidoRepository.getReferenceById(idPedido);
			return pedido.getUsuario();
		} catch(Exception e) {
			return null;
		}
		
	}

	@Override
	public List<Pedido> buscarPedidosConMasDe(int cantidadLineas) {
		return pedidoRepository.findPedidosConMasdeLineas(cantidadLineas);
	}

}
