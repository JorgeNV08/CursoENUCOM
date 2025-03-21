package com.mx.ATM.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ATM.Entity.ValorNominal;

public interface IValorNominalDao extends JpaRepository<ValorNominal, Integer> {

}
