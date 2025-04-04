package com.mx.ReservaSala.Service;

import java.util.List;

import com.mx.ReservaSala.Entity.Reserva;

public interface IReservaServ {

	public List<Reserva> listar();
	
	public Reserva buscar(int idReserva);
	
	public Reserva guardar(Reserva reserva);
	
	public Reserva editar(Reserva reserva);
	
	public Reserva eliminar(int idReserva);
	
	
}
