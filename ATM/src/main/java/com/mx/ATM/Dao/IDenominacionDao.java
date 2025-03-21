package com.mx.ATM.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ATM.Entity.Denominacion;

public interface IDenominacionDao extends JpaRepository<Denominacion, Integer> {

}
