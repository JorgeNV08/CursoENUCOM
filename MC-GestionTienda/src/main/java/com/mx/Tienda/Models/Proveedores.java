package com.mx.Tienda.Models;

import lombok.Data;

@Data
public class Proveedores {

	private Long id;
	private String nombre;
	private String contacto;
	private String empresa;
	private int tiendaId;
	
}
