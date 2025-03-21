package com.mx.SalaCine.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.SalaCine.Entity.Sala;
import com.mx.SalaCine.Service.SalaServiceImpl;

@RestController // Indicamos que la clase es un controlador y recibe solicitudes HTTP y devuelve
				// una respuesta
@RequestMapping("/Sala")
@CrossOrigin	//Evita que tengamos acceso denegado al solicitar informacion al servidor
public class SalaWS {

	//Inyeccion de dependencias
	@Autowired
	private  SalaServiceImpl service;
	
	//Creacion de EndPoints
	
	//Listar
	//http://localhost:8002/Sala/listar
	@GetMapping("listar")
	public List<Sala> listar(){
		return service.listar();
	}
	
	//Buscar
	//http://localhost:8002/Sala/buscar
	@PostMapping("buscar")
	public Sala buscar(@RequestBody Sala sala) {
		return service.buscar(sala);	
	}
	
	//Guardar
	//http://localhost:8002/Sala/guardar
	@PostMapping("guardar")
	public Sala guardar(@RequestBody Sala sala) {
		System.out.println(sala);
		return service.guardar(sala);
	}
	
	//Editar
	//http://localhost:8002/Sala/editar
	@PutMapping("editar")
	public Sala editar(@RequestBody Sala sala) {
		return service.editar(sala);
	}
	
	//Eliminar
	//http://localhost:8002/Sala/eliminar
	@DeleteMapping("eliminar")
	public Sala eliminar(@RequestBody Sala sala) {
		return service.eliminar(sala);
	}
	
	//Metodos personalizados
	//Buscar por categoria 1
	//http://localhost:8002/Sala/buscarPorCategoria?categoria=B15
	@PostMapping("buscarPorCategoria")
	public List<Sala> buscarPorCategoria(@Param("categoria") String categoria){
		return service.findByCategoria(categoria);
	}
	
	@PostMapping("buscarPorCategoria2")
	public List<Sala> buscarPorCategoria2(@Param("categoria") String categoria){
		return service.findByCategoria2(categoria);
	}
	
	@GetMapping("/obtener/{idSala}")
	public Sala buscarPorId(@PathVariable Long idSala) {
		return service.findByIdSala(idSala);
	}
	
}	
