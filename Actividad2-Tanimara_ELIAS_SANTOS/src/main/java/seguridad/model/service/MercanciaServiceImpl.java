package seguridad.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seguridad.model.entity.Mercancia;
import seguridad.model.repository.MercanciaRepository;

@Service
public class MercanciaServiceImpl implements IMercanciaService {
	
	@Autowired
	private MercanciaRepository repo;

	@Override
	public List<Mercancia> listarPendientes() {
		return repo.findByEstado("PENDIENTE");
	}

	@Override
	public List<Mercancia> buscarPorFiltros(String origen, String destino, Double pesoMax) {
		return repo.findAll().stream()
		.filter(m -> origen == null || m.getOrigen().equalsIgnoreCase(origen))
		.filter(m-> destino == null || m.getDestino().equalsIgnoreCase(destino))
		.filter(m -> pesoMax == null || m.getPesoKg() <= pesoMax)
		.collect(Collectors.toList());
	}
	
	@Override
	public Mercancia guardar(Mercancia mercancia) {
		if(mercancia.getEstado() == null) {
			mercancia.setEstado("PENDIENTE");
		}
		return repo.save(mercancia);
	}
	

}
