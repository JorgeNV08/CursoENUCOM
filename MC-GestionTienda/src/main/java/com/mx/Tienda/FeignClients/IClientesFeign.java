package com.mx.Tienda.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.Tienda.Models.Clientes;

@FeignClient(
		name = "MC-Clientes",
		url = "http://localhost:8013",
		path = "/Clientes"
		)

public interface IClientesFeign {

	//Declaración de los controladores del Microservicio MC-Clientes
	@PostMapping
	public Clientes save(@RequestBody Clientes cliente);
	
	@GetMapping("tienda/{tiendaId}")
	public List<Clientes> getClientesByTiendaId(@PathVariable int tiendaId);
}
