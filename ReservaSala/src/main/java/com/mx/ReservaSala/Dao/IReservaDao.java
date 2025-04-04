package com.mx.ReservaSala.Dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ReservaSala.Entity.Reserva;

public interface IReservaDao extends JpaRepository<Reserva, Integer> {

	public List<Reserva> findBySalaIdAndFecha(int salaId, LocalDate fecha);
}
