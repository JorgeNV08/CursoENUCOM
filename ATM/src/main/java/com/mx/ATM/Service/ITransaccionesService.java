package com.mx.ATM.Service;

import java.util.List;

import com.mx.ATM.Entity.Transacciones;


public interface ITransaccionesService {

	public Transacciones guardar(Transacciones transaccion);
	
	public Transacciones editar (Transacciones transaccion);
	
	public Transacciones eliminar (Transacciones transaccion);
	
	public Transacciones buscar(int idTransaccion);
	
	public List<Transacciones> listar();
}
