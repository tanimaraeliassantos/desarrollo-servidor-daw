package pedidos.restcontroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pedidos.modelo.entities.Pedido;
import pedidos.modelo.entities.Usuario;
import pedidos.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoRestController {
	private final PedidoService pedidoService;
	
	public PedidoRestController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@GetMapping("/{idPedido}/usuario")
	public ResponseEntity<Usuario> buscarClientePorIdPedido(@PathVariable int idPedido) {
		
		Usuario usuario = this.pedidoService.buscarUsuarioPorIdPedido(idPedido);
		if(usuario != null) {
			return new ResponseEntity<>(usuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/lineas-mayores-que")
	public ResponseEntity<List<Pedido>> pedidoConMasdeLineas(@RequestParam int n) {
		List<Pedido> pedidos = pedidoService.buscarPedidosConMasDe(n);
		
		if(pedidos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(pedidos, HttpStatus.OK);
	}
	
	

}
