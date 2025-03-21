package com.mx.Clientes.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Clientes.Entity.Clientes;

public interface IClientesDao extends JpaRepository<Clientes, Integer> {

	public List<Clientes> findByTiendaId(int tiendaId);
}
