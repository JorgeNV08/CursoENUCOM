package com.mx.ReservaSala.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="RESERVA_SALA")
@Data
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReserva;
	private int salaId;
	private String usuario;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	@JsonFormat(pattern = "HH:mm")
	private LocalTime hora;
	private int duracion;
	
	
	
}
