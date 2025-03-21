package com.mx.FuncionCine.Models;
import lombok.Data;

@Data
public class Sala {

	private Long idSala; 
	private int noAsientos; 
	private String tipoPantalla;
	private String categoria;
	private int salaId;
	/*//Referencia a la Otra Tabla
	@OneToMany(mappedBy = "salaId", cascade = CascadeType.ALL)
	List<Boleto> list = new ArrayList<>();*/
}