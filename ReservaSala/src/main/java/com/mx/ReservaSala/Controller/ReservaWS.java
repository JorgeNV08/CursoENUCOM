package com.mx.ReservaSala.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ReservaSala.Entity.Reserva;
import com.mx.ReservaSala.Service.ReservaServImpl;

@RestController
public class ReservaWS {

	@Autowired
	ReservaServImpl service;
	
	@GetMapping("api/reservas")
	public ResponseEntity<?> listar(){
		List<Reserva> reservaciones = service.listar();
		if(reservaciones.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(reservaciones);
	}
	
	
	@PostMapping("api/reservas")
	public ResponseEntity<?> crearReserva(@RequestBody Reserva reserva){
		Reserva nuevaReserva = 	service.guardar(reserva);
		if(nuevaReserva!=null)
			return ResponseEntity.status(HttpStatus.OK).body(reserva);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("mensaje: La sala ya está reservada para el horario especificado");
		
	}
	
	@DeleteMapping("api/reservas/{idReserva}")
	public ResponseEntity<?> cancelarReserva(@PathVariable int idReserva){
		Reserva aux = service.buscar(idReserva);
		if(aux!=null) {
			service.eliminar(idReserva);
			return ResponseEntity.status(HttpStatus.OK).body("mensaje: Reserva cancelada exitosamente");
			}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("api/salas/{idSala}/reservas")
	public ResponseEntity<?> listarReservas(@PathVariable int idSala, @RequestParam LocalDate fecha){
		List<Reserva> reservaciones = service.listarSalaYFecha(idSala, fecha);
		if(reservaciones.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("mensaje: NO HAY NADA");
		return ResponseEntity.status(HttpStatus.OK).body(reservaciones);
	}

	
	
}
