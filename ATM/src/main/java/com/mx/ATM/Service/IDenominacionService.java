package com.mx.ATM.Service;

import java.util.List;

import com.mx.ATM.Entity.Denominacion;

public interface IDenominacionService {
	
	public Denominacion guardar(Denominacion denominacion);
	
	public Denominacion editar (Denominacion denominacion);
	
	public Denominacion eliminar (Denominacion denominacion);
	
	public Denominacion buscar(int idDenominacion);
	
	public List<Denominacion> listar();
}
