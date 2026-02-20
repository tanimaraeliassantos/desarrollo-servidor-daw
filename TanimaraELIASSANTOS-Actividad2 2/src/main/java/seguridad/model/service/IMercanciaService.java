package seguridad.model.service;

import java.util.List;

import seguridad.model.entity.Mercancia;

public interface IMercanciaService {
	Mercancia guardar(Mercancia mercancia);
	List<Mercancia> listarPendientes();
	List<Mercancia> buscarPorFiltros(String origen, String destino, Double pesoMax);

}
