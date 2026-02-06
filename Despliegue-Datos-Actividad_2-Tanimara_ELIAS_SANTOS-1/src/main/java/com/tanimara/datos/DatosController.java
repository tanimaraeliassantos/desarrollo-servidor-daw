package com.tanimara.datos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatosController {
	@Autowired
	private UsuarioRepository repo;
	
	@GetMapping("/insertar")
	public String insertar(@RequestParam String nombre) {
		Usuario u = new Usuario();
		u.setNombre(nombre);
		repo.save(u);
		return "Usuario " + nombre + " guardado en base de datos correctamente.";
	}

}
