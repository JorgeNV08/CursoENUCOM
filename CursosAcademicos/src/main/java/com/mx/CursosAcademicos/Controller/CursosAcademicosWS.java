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

import com.mx.CursosAcademicos.Entity.CursosAcademicos;
import com.mx.CursosAcademicos.Service.ICursosAcademicosServiceImpl;

@RestController
@RequestMapping("/CursosAcademicos")
@CrossOrigin
public class CursosAcademicosWS {

	@Autowired
	private ICursosAcademicosServiceImpl service;
	
	//LISTAR
	//http://localhost:8004/CursosAcademicos
	@GetMapping
	public List<CursosAcademicos> listar(){
		return service.listar();
	}
	
	//BUSCAR
	//http://localhost:8004/CursosAcademicos/idCurso
	@PostMapping("/{idCurso}")
	public CursosAcademicos buscar(@PathVariable int idCurso) {
		return service.buscar(idCurso);
	}
	
	//GUARDAR
	//http://localhost:8004/CursosAcademicos
	@PostMapping
	public CursosAcademicos guardar(@RequestBody CursosAcademicos cursos) {
		return service.guardar(cursos);
	}
	
	//EDITAR
	//http://localhost:8004/CursosAcademicos
	@PutMapping
	public CursosAcademicos editar(@RequestBody CursosAcademicos cursos) {
		return service.editar(cursos);
	}
	
	
	//ELIMINAR
	//http://localhost:8004/CursosAcademicos
	@DeleteMapping
	public CursosAcademicos eliminar(@RequestBody CursosAcademicos cursos) {
		return service.eliminar(cursos);
	}
	
	
}
