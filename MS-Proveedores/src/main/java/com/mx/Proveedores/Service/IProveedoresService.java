package com.mx.Proveedores.Service;

import java.util.List;

import com.mx.Proveedores.Entity.Proveedores;

public interface IProveedoresService {

	public Proveedores guardar(Proveedores proveedor);

	public Proveedores editar(Proveedores proveedor);

	public Proveedores eliminar(int id);

	public Proveedores buscar(int id);

	public List<Proveedores> listar();
	
	public List<Proveedores> findByTiendaId(int tiendaId);
}
