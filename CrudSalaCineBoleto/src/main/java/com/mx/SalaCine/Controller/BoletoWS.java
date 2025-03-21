package com.mx.SalaCine.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.SalaCine.Entity.Boleto;
import com.mx.SalaCine.Entity.Sala;
import com.mx.SalaCine.Service.BoletoServiceImpl;

@RestController
@RequestMapping("/Boleto")
@CrossOrigin 
public class BoletoWS {

	@Autowired
	private BoletoServiceImpl service;
	
		//Creacion de EndPoints
	
		//Listar
		//http://localhost:8002/Boleto/listar
		@GetMapping("listar")
		public List<Boleto> listar(){
			return service.listar();
		}
		
		//Buscar
		//http://localhost:8002/Boleto/buscar
		@PostMapping("buscar")
		public Boleto buscar(@RequestBody Boleto boleto) {
			return service.buscar(boleto);	
		}
		
		//Guardar
		//http://localhost:8002/Boleto/guardar
		@PostMapping("guardar")
		public Boleto guardar(@RequestBody Boleto boleto) {
			return service.guardar(boleto);
		}
		
		//Editar
		//http://localhost:8002/Boleto/editar
		@PutMapping("editar")
		public Boleto editar(@RequestBody Boleto boleto) {
			return service.editar(boleto);
		}
		
		//Eliminar
		//http://localhost:8002/Boleto/eliminar
		@DeleteMapping("eliminar")
		public Boleto eliminar(@RequestBody Boleto boleto) {
			return service.eliminar(boleto);
		}
		
		//Metodos personalizados
		/*
		 * //Metodos personalizados
			public List<Boleto> buscarPorPelicula(String nomPelicula){
				return dao.findByNomPelicula(nomPelicula);
			}
			
			public List<Boleto> buscarPorClasificacion(String clasificacion){
				return dao.findByClasificacion(clasificacion);
			}
		 * */
		
		//Buscar por Pelicula
		//http://localhost:8002/Boleto/buscarPorPelicula?nomPelicula=
		@PostMapping("buscarPorPelicula")
		public List<Boleto> buscarPorPelicula(@Param("nomPelicula") String nomPelicula){
			return service.buscarPorPelicula(nomPelicula);
		}
		
		//Buscar por Pelicula
		//http://localhost:8002/Boleto/buscarPorClasificacion?nomPelicula=
		@PostMapping("buscarPorClasificacion")
		public List<Boleto> buscarPorClasificacion(@Param("clasificacion") String clasificacion){
			return service.buscarPorClasificacion(clasificacion);
		}
		
}
