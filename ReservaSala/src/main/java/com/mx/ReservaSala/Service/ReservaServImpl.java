package com.mx.ReservaSala.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.ReservaSala.Dao.IReservaDao;
import com.mx.ReservaSala.Entity.Reserva;

@Service
public class ReservaServImpl implements IReservaServ{

	@Autowired
	IReservaDao dao;
	
	@Override
	public List<Reserva> listar() {
		return dao.findAll();
	}

	@Override
	public Reserva buscar(int idReserva) {
		return dao.findById(idReserva).orElse(null);
	}

	@Override
	public Reserva guardar(Reserva reserva) {
		return dao.save(reserva);
	}

	@Override
	public Reserva editar(Reserva reserva) {
		Reserva aux = this.buscar(reserva.getIdReserva());
		if(aux != null)
			return dao.save(aux);
		return null;
	}

	@Override
	public Reserva eliminar(int idReserva) {
		Reserva aux = this.buscar(idReserva);
		if(aux!=null) {
			dao.deleteById(idReserva);
			return aux;
		}
		return null;
	}
	
	//Metodos personalizados
	public List<Reserva> listarSalaYFecha(int salaId, LocalDate fecha){
		List<Reserva> reservaciones= dao.findBySalaIdAndFecha(salaId, fecha);
		return reservaciones;
	}
	

}
