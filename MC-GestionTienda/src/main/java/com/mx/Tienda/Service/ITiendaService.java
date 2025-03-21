package com.mx.Tienda.Service;

import java.util.List;

import com.mx.Tienda.Entity.Tienda;


public interface ITiendaService {

public Tienda guardar(Tienda tienda);
	
	public Tienda editar(Tienda tienda);
	
	public Tienda eliminar(int idTienda);
	
	public Tienda buscar(int idTienda);
	
	public List<Tienda> listar();
}
