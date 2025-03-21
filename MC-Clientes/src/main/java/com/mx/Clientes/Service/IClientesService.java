package com.mx.Clientes.Service;

import java.util.List;

import com.mx.Clientes.Entity.Clientes;

public interface IClientesService {

	public Clientes guardar(Clientes cliente);
	
	public Clientes editar(Clientes cliente);
	
	public Clientes eliminar(int idCliente);
	
	public Clientes buscar(int idCliente);
	
	public List<Clientes> listar();
	
}
