package pedidos.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pedidos.modelo.dto.LineaPedidoDto;
import pedidos.modelo.dto.ProductoVentaDto;
import pedidos.modelo.entities.LineasPedido;
import pedidos.modelo.repository.LineasPedidoRepository;
import pedidos.service.LineasPedidoService;

@RestController
@RequestMapping("/lp")
public class LineasPedidoRestController {
	
	private final LineasPedidoService lpService;
	
	public LineasPedidoRestController(LineasPedidoService lpService) {
		this.lpService = lpService;
	}
	
	
	@GetMapping("/")
	public List<LineaPedidoDto> todas(){
		return lpService.buscarTodas()
				.stream()
				.map(LineaPedidoDto::convertALineaPedidoDto)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/groupByPedido")
	public List<ProductoVentaDto> getCantidadTotalVendida() {
		return lpService.getCantidadTotalVendida()
;	}
	
	

}
