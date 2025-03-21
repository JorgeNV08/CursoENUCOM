package com.mx.Empleados.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

import com.mx.Empleados.Entity.Empleados;
import com.mx.Empleados.Service.EmpleadosServImpl;

@RestController
@RequestMapping("/Empleados") //http://localhost:8100/Empleados
@CrossOrigin
public class EmpleadosWS {

	@Autowired
	private EmpleadosServImpl service;
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Empleados empleado){
		Empleados nuevoEmpleado = service.guardar(empleado);
		
		if(nuevoEmpleado!=null)
			return ResponseEntity.status(HttpStatus.OK).body(nuevoEmpleado);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/{idEmpleado}")
	public ResponseEntity<?> buscar(@PathVariable int idEmpleado){
		Empleados empleado = service.buscar(idEmpleado);
		
		if(empleado!=null)
			return ResponseEntity.status(HttpStatus.OK).body(empleado);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Empleados empleado){
		Empleados aux = service.buscar(empleado.getIdEmpleado());
		
		if(aux!=null)
			if(service.editar(empleado)!=null) {
				return ResponseEntity.status(HttpStatus.OK).body(empleado);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping
	public ResponseEntity<?> eliminar(@Param("idEmpleado") int idEmpleado){
		Empleados aux = service.buscar(idEmpleado);
		
		if(aux!=null)
			if(service.eliminar(idEmpleado)!=null) {
				return ResponseEntity.status(HttpStatus.OK).body(aux);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Empleados> empleados = service.listar();
		
		if(empleados.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(empleados);
	}
	
}
