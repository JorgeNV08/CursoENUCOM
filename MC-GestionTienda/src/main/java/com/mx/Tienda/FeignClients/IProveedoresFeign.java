package com.mx.Tienda.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.Tienda.Models.Proveedores;

@FeignClient(
		name = "MS-Proveedores",
		url = "http://localhost:8011",
		path = "/Proveedor"
		)
public interface IProveedoresFeign {

	//Declaracion de los controladores del Microservicio MS-Proveedores
	@GetMapping("/Tienda/{tiendaId}")
	public List<Proveedores> getProveedorById(@PathVariable int tiendaId);
	
	@PostMapping
	public Proveedores save(@RequestBody Proveedores proveedor);
	
	
}
