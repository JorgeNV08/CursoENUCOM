package com.example.Bicicleta.Controller;

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

import com.example.Bicicleta.Dominio.Bicicleta;
import com.example.Bicicleta.Servicio.BicicletaServiceImpl;

@RestController
@RequestMapping(path = "/api/v1/Bici")
public class BicicletaWS {

	// ************************PASO 8 @Autowired y posterior crear los EndPoints
	// inyeccion de dependencias del @Service
	@Autowired
	private BicicletaServiceImpl service;

	// ---CREACION DE EndPoints

	// Endpoint: "Listar"
	// URL: http://localhost:8080/api/v1/Bici/listar
	@GetMapping(value = "listar")
	public List<Bicicleta> listar() {
		return service.listar();
	}

	// Endpoint: "Buscar"
	// URL: http://localhost:8080/api/v1/Bici/buscar/{1}
	@PostMapping(value = "buscar/{idBici}")
	public Bicicleta buscar(@PathVariable int idBici) {
		return service.buscar(idBici);
	}

	// Endpoint: "Guardar"
	// URL: http://localhost:8080/api/v1/Bici/guardar
	@PostMapping(value = "guardar")
	public void guardar(@RequestBody Bicicleta bici) {
		/*
		 * @RequestBody sirve para deserializar el documento JSON y convertirlo en un
		 * Objeto Java
		 * 
		 * @ResponseBody sirve para deserializar el Objeto Java y convertirlo en un
		 * documento JSON
		 */
		
		service.guardar(bici);
	}

	
	// Endpoint: "Editar"
		// URL: http://localhost:8080/api/v1/Bici/editar
		@PutMapping(value = "editar")
		public void editar (@RequestBody Bicicleta bici) {
			service.editar(bici);
		}
	
		
	// Endpoint: "Eliminar"
			// URL: http://localhost:8080/api/v1/Bici/eliminar/idBici
			@DeleteMapping(value = "eliminar/{idBici}")
			public void eliminar (@PathVariable int idBici) {
				service.eliminar(idBici);
			}
			
	
	
}
