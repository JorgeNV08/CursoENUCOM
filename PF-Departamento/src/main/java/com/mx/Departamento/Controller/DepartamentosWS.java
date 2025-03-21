package com.mx.Departamento.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Departamento.Entity.Departamentos;
import com.mx.Departamento.Service.DepServImpl;

@RestController
@RequestMapping("/Departamentos") //http://localhost:8101/Departamentos
@CrossOrigin
public class DepartamentosWS {

	@Autowired
	DepServImpl service;
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Departamentos departamento){
		Departamentos nuevoDep = service.guardar(departamento);
		
		if(nuevoDep!=null)
			return ResponseEntity.status(HttpStatus.OK).body(nuevoDep);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/{idDepartamento}")
	public ResponseEntity<?> buscar(@PathVariable int idDepartamento){
		Departamentos aux = service.buscar(idDepartamento);
		
		if(aux!=null)
			return ResponseEntity.status(HttpStatus.OK).body(aux);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Departamentos departamento){
		Departamentos aux = service.buscar(departamento.getIdDepartamento());
		
		if(aux!=null) {
			if(service.editar(departamento) != null) {
				return ResponseEntity.status(HttpStatus.OK).body(departamento);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	
	
	
	
	
	
	
	
}
