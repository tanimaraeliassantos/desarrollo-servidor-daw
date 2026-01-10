package pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pedidos.modelo.dto.ProductoVentaDto;
import pedidos.modelo.entities.LineasPedido;
import pedidos.modelo.entities.Usuario;
import pedidos.modelo.repository.LineasPedidoRepository;

@Service
public class LineasPedidoServiceImplDataJpaMy8 implements LineasPedidoService{
	@Autowired
	private LineasPedidoRepository lpRepo;

	@Override
	public List<LineasPedido> buscarTodas() {
		return lpRepo.findAll();
	}

	@Override
	public List<ProductoVentaDto> getCantidadTotalVendida() {
		return lpRepo.getCantidadTotalVendida();
	}


	
	
}
