package com.mx.CursosAcademicos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CursosAcademicos.Entity.Inscripcion;
import com.mx.CursosAcademicos.Service.IInscripcionServiceImpl;

@RestController
@RequestMapping("/Inscripcion")
@CrossOrigin("*")
public class InscripcionWS {

	@Autowired
	private IInscripcionServiceImpl service;
	
		//LISTAR
		//http://localhost:8004/Inscripcion
		@GetMapping
		public List<Inscripcion> listar(){
			return service.listar();
		}
		
		//BUSCAR
		//http://localhost:8004/Inscripcion/{idInscripcion}
		@PostMapping("/{idCurso}")
		public Inscripcion buscar(@PathVariable int idInscripcion) {
			return service.buscar(idInscripcion);
		}
		
		//GUARDAR
		//http://localhost:8004/CursosAcademicos
		@PostMapping
		public Inscripcion guardar(@RequestBody Inscripcion insc) {
			return service.guardar(insc);
		}
		
		//EDITAR
		//http://localhost:8004/CursosAcademicos
		@PutMapping
		public Inscripcion editar(@RequestBody Inscripcion insc) {
			return service.editar(insc);
		}
		
		
		//ELIMINAR
		//http://localhost:8004/CursosAcademicos
		@DeleteMapping
		public Inscripcion eliminar(@RequestBody Inscripcion insc) {
			return service.eliminar(insc);
		}
	
}
