package com.mx.Clientes.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CLIENTES")
@Data
public class Clientes {

	@Id
	private int idCliente;
	private String nombre;
	private String direccion;
	private Long contacto;
	private int tiendaId;
	
	
}

/*
 	CREAE TABLE CLIENTES(
 		ID_CLIENTE NUMBER,
 		NOMBRE NVARCHAR2(100),
 		DIRECCION NVARCHAR2(100),
 		CONTACTO NUMBER,
 		TIENDA_ID NUMBER,
 		CONSTRAINT ID_CLIENTE_PK PRIMARY KEY(ID_CLIENTE)
 		
 	);
  
  
 * */