package com.mx.Departamento.Service;

import java.util.List;

import com.mx.Departamento.Entity.Departamentos;

public interface IDepService {

	public Departamentos guardar(Departamentos departamento);
	
	public Departamentos buscar(int idDepartamento);
	
	public Departamentos editar(Departamentos departamento);
	
	public Departamentos eliminar(int idDepartamento);
	
	public List<Departamentos> listar(); 
}
