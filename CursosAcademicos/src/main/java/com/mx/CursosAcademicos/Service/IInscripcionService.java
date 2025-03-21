package com.mx.CursosAcademicos.Service;

import java.util.List;

import com.mx.CursosAcademicos.Entity.Inscripcion;

public interface IInscripcionService {

	public Inscripcion guardar(Inscripcion insc);
	
	public Inscripcion editar(Inscripcion insc);
	
	public Inscripcion eliminar(Inscripcion insc);
	
	public Inscripcion buscar(int idInscripcion);
	
	public List<Inscripcion> listar();
}
