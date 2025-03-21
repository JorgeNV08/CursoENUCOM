package com.mx.FuncionCine.Service;

import java.util.List;

import com.mx.FuncionCine.Entity.FuncionCine;

public interface IFunCineService {

	public FuncionCine guardar(FuncionCine funcion);
	
	public FuncionCine editar(FuncionCine funcion);
	
	public FuncionCine eliminar(int idFuncion);
	
	public FuncionCine buscar(int idFuncion);
	
	public List<FuncionCine> listar();
}
