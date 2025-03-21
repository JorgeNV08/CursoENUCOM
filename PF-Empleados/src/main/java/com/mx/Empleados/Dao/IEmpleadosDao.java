package com.mx.Empleados.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Empleados.Entity.Empleados;

public interface IEmpleadosDao extends JpaRepository<Empleados, Integer> {

}
