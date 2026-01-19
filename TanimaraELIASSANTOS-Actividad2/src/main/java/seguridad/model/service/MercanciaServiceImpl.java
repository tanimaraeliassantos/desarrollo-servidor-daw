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
		return repo.findByEstado("pendiente");
	}

	@Override
	public List<Mercancia> buscarPorFiltros(String origen, String destino, Double pesoMax) {
		
		List<Mercancia> resultados;
		
		if ((origen != null || destino !=null)) {
			String o = (origen!=null) ? origen: "";
			String d = (destino !=null) ? destino: "";
	        resultados = repo.findByOrigenIgnoreCaseOrDestinoIgnoreCase(o, d);
	    } else {
	        resultados = repo.findByEstado("pendiente");
	    }
		
		return resultados.stream()
		.filter(m -> origen == null || m.getOrigen().equalsIgnoreCase(origen))
		.filter(m-> destino == null || m.getDestino().equalsIgnoreCase(destino))
		.filter(m -> pesoMax == null || m.getPesoKg() <= pesoMax)
		.collect(Collectors.toList());
	}
	
	@Override
	public Mercancia guardar(Mercancia mercancia) {
		if(mercancia.getEstado() == null) {
			mercancia.setEstado("pendiente");
		}
		return repo.save(mercancia);
	}
	

}
