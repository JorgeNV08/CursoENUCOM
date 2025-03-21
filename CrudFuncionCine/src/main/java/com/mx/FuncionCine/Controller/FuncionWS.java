package com.mx.FuncionCine.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.FuncionCine.Entity.FuncionCine;
import com.mx.FuncionCine.Models.Sala;
import com.mx.FuncionCine.Service.FunCineImpl;

@RestController
@RequestMapping("/Funcion") //http://localhost:8014/Funcion
@CrossOrigin
public class FuncionWS {

	@Autowired
	FunCineImpl service;
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody FuncionCine funcion){
		FuncionCine nuevaFuncion = service.guardar(funcion);
		
		if(nuevaFuncion!=null)
			return ResponseEntity.status(HttpStatus.OK).body(nuevaFuncion);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody FuncionCine funcion){
		FuncionCine aux = service.buscar(funcion.getIdFuncion());
		
		if(aux!=null) {
			if(service.editar(funcion)!=null)
				return ResponseEntity.status(HttpStatus.OK).body(funcion);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping("/{idFuncion}")
	public ResponseEntity<?> eliminar(@PathVariable int idFuncion){

		FuncionCine aux = service.buscar(idFuncion);
		
		if(aux!=null) {
			if(service.eliminar(idFuncion)!=null)
				return ResponseEntity.status(HttpStatus.OK).body(aux);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	
	@GetMapping("/{idFuncion}")
	public ResponseEntity<?> buscar(@PathVariable int idFuncion){
		FuncionCine aux = service.buscar(idFuncion);
		if(aux!=null)
			return ResponseEntity.status(HttpStatus.OK).body(aux);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<FuncionCine> funcion = service.listar();
		
		if(funcion.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(funcion);
	}
	
	
	// --------------------------------------------------S A L A S 
	//Endpoint Listar Salas
	@GetMapping("/Sala")
	public ResponseEntity<?> obtenerSalas(){
		List<Sala> sala = service.listarSala();
		if(sala.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(sala);
	}	
}
