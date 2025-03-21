package com.mx.Proveedores.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "PROVEEDORES")
@Data
public class Proveedores {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_PROVEEDORES")
	@SequenceGenerator(name="SEQ_ID_PROVEEDORES", sequenceName = "S_ID_PROVEEDORES", allocationSize = 1)
	private int id;
	private String nombre;
	private String contacto;
	private String empresa;
	private int tiendaId;
	
}
