package com.mx.Camaras.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Camaras.Dominio.Camara;
import com.mx.Camaras.Servicio.ICamaraServiceImpl;

@RestController
@RequestMapping(path="/api/v1/Camara")
public class CamaraWS {

	@Autowired
	private ICamaraServiceImpl service;
	
	// Endpoint: "Listar"
	// URL: http://localhost:8080/api/v1/Camara/listar
	@GetMapping(value = "listar")
	public List<Camara> listar() {
		return service.listar();
	}
	
	// Endpoint: "Buscar"
	// URL: http://localhost:8080/api/v1/Camara/buscar/1
	@PostMapping(value = "buscar/{idCam}")
	public Camara buscar(@PathVariable int idCam) {
		return service.buscar(idCam);
	}

	// Endpoint: "Guardar"
	// URL: http://localhost:8080/api/v1/Camara/guardar
	@PostMapping(value = "guardar")
	public void guardar(@RequestBody Camara cam) {
		service.guardar(cam);
	}

	
	// Endpoint: "Editar"
	// URL: http://localhost:8080/api/v1/Camara/editar
	@PutMapping(value = "editar")
	public void editar (@RequestBody Camara cam) {
		service.editar(cam);
	}
	
		
	// Endpoint: "Eliminar"
	// URL: http://localhost:8080/api/v1/Camara/eliminar/1
	@DeleteMapping(value = "eliminar/{idCam}")
	public void eliminar (@PathVariable int idCam) {
		service.eliminar(idCam);
	}
				
	
}
