package seguridad.model.service;

import java.util.List;
import java.util.Map;

import seguridad.model.entity.Mercancia;

public interface IMercanciaService {
	Mercancia guardar(Mercancia mercancia);
	List<Mercancia> listarPendientes();
	List<Mercancia> buscarPorFiltros(String origen, String destino, Double pesoMax);
	//Añadido para prueba trimestral
	Map<String, Long> obtenerEstadisticasPorEstado();
	List<Mercancia> buscarPorDistanciaMinima(Double distanciaMinima);
}
