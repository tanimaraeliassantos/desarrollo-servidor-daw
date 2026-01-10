package pedidos.restcontroller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pedidos.modelo.entities.Usuario;
import pedidos.service.PedidoService;
import pedidos.service.UsuarioService;

@RestController
@RequestMapping("/clientes")
public class UsuarioRestController {
	@Autowired
	private final UsuarioService usuarioService;
	private final PedidoService pedidoService;
	private List<Usuario> lista;
	
	public UsuarioRestController(PedidoService pedidoService, UsuarioService usuarioService) {
		this.pedidoService = pedidoService;
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/por-email/{texto}")
	public List<Usuario> findByEmailContaining(@PathVariable String texto) {
		return usuarioService.findByEmailContaining(texto);
	}
	
	@GetMapping("/con-pedidos")
	public List<Usuario> buscarConPedidos() {
		return pedidoService.buscarUsuariosConPedidos();
	}
	
	@GetMapping("/registrados-despues/{fecha}")
	public List<Usuario> findfindByFechaRegistroAfter(@PathVariable LocalDate fecha) {
		return usuarioService.findByFechaRegistroAfter(fecha);
	}

}
