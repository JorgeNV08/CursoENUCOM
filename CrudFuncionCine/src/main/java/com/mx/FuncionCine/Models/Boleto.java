package com.mx.FuncionCine.Models;

import java.sql.Date;

import lombok.Data;

@Data
public class Boleto {

	private Long idBoleto;
	private String nomPelicula;
	private String clasificacion;
	private String noAsiento;
	private Date fecha;
	private int salaId;
}
