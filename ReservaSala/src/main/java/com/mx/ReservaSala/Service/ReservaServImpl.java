package com.mx.ReservaSala.Service;

import java.time.LocalDate;
import java.time.LocalTime;
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
		//Fechas invalidas en el pasado
		if(reserva.getFecha().isBefore(LocalDate.now()))
			throw new IllegalArgumentException("No se permiten fechas pasadas");
		
		//Duracion max de 4 hrs
		if (reserva.getDuracion()>4)
			throw new IllegalArgumentException("La duración máxima de una reserva es de 4 horas.");
		
		//Horario permitido entre 8-20 hrs
		LocalTime horaInicio = reserva.getHora();
		LocalTime horaFin = horaInicio.plusHours(reserva.getDuracion()); //Hora inicio + duración = Hora Fin
		LocalTime horarioPermInicio = LocalTime.of(8, 0);
		LocalTime horarioPermFin = LocalTime.of(20, 0);
		
		if(horaInicio.isBefore(horarioPermInicio) || horaFin.isAfter(horarioPermFin))
			throw new IllegalArgumentException("La reservación debe estar en un horario entre 8:00 - 20:00 hrs");
		
		//Verificar que no haya solapamiento entre sala y horarios
		List<Reserva> reservasExist = dao.findBySalaIdAndFecha(reserva.getSalaId(), reserva.getFecha());
		
		if(reservasSolapadas(reserva, reservasExist)) //Si estan solapadas manda excepción
			throw new IllegalArgumentException("Ya existe una reserva que se solapa con ese horario.");
		
		
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
	//Metodo personalizado 2
	public boolean reservasSolapadas(Reserva nuevaReserva, List<Reserva> reservasExist) {
		LocalTime nuevaResInicio = nuevaReserva.getHora();
		LocalTime nuevaResFinal = nuevaResInicio.plusHours(nuevaReserva.getDuracion());
		
		for(Reserva reservaActual: reservasExist) {
			LocalTime actualInicio = reservaActual.getHora();
			LocalTime actualFin = actualInicio.plusHours(reservaActual.getDuracion());
			
			// La nueva reserva termina antes de que empiece la actual || empieza después de que la actual ya terminó
			boolean seCruzan = !(nuevaResFinal.isBefore(actualInicio) || nuevaResInicio.isAfter(actualFin));
			if(seCruzan)
				return true;
		}
		return false;
	}

}
