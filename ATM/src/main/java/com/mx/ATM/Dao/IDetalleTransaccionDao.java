package com.mx.ATM.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ATM.Entity.DetalleTransaccion;

public interface IDetalleTransaccionDao extends JpaRepository<DetalleTransaccion, Integer>{

}
