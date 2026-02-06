package com.tanimara.despliegue;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {
	@GetMapping("/saludo")
	public String hola() {
		return "<h1>Despliegue con éxito!</h1>" +
				"<p> Este es el proyecto 1 de Tanimara levantado en Tomcat.</p>";
	}
}
