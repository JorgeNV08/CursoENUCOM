package com.mx.Productos.Service;

import java.util.List;

import com.mx.Productos.Entity.Productos;

public interface IProductosService {

	public Productos guardar(Productos producto);

	public Productos editar(Productos producto);

	public Productos eliminar(int idProducto);

	public Productos buscar(int idProducto);

	public List<Productos> listar();
	
}
