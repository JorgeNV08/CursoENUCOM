package com.mx.ATM.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.ATM.Entity.Transacciones;

public interface ITransaccionesDao extends JpaRepository<Transacciones, Integer> {

	@Query("SELECT MAX(t.idTransaccion) FROM Transacciones t")
    Integer getLastTransactionId();
}
