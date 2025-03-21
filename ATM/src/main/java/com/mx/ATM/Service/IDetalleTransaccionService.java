package com.mx.ATM.Service;

import java.util.List;

import com.mx.ATM.Entity.DetalleTransaccion;

public interface IDetalleTransaccionService {

	public DetalleTransaccion guardar(DetalleTransaccion detalleTransaccion);
	
	public DetalleTransaccion editar (DetalleTransaccion detalleTransaccion);
	
	public DetalleTransaccion eliminar (DetalleTransaccion detalleTransaccion);
	
	public DetalleTransaccion buscar(int idDetalleTransaccion);
	
	public List<DetalleTransaccion> listar();
}
