package com.mx.ATM.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ATM.Entity.Cajero;

public interface ICajeroDao extends JpaRepository<Cajero, Integer> {

}
