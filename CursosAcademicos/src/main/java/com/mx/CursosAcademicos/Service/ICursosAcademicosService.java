package com.mx.CursosAcademicos.Service;

import java.util.List;

import com.mx.CursosAcademicos.Entity.CursosAcademicos;

public interface ICursosAcademicosService {

	public CursosAcademicos guardar(CursosAcademicos cursos);
	
	public CursosAcademicos editar(CursosAcademicos cursos);
	
	public CursosAcademicos eliminar(CursosAcademicos cursos);
	
	public CursosAcademicos buscar(int idCurso);

	public List<CursosAcademicos> listar();
}

