package com.mx.FuncionCine.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.FuncionCine.Entity.FuncionCine;

public interface IFunCineDao extends JpaRepository<FuncionCine, Integer>{

}
