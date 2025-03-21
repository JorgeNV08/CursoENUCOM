package com.example.Bicicleta.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BICICLETA")
public class Bicicleta {

	/*
	 * ******************* PASO 1 CREAR ATRIBUTOS SIMILARES A TU BASE DE DATOS
	 * ******************* PASO 2 POR MEDIO DE ENTITY, TABLE, ID Y COLUMN IMPORTAR LOS DATOS DE LA BASE DE DATOS
	 * CREATE TABLE BICICLETA( ID_BICI NUMBER,
	 * 		MARCA NVARCHAR2(50),
	 * 		MODELO NVARCHAR2(30),
	 * 		TIPO NVARCHAR2(30),
	 * 		COLOR NVARCHAR2(30),
	 * 		RODADA NUMBER,
	 * 		MATERIAL NVARCHAR2(30),
	 * 		PRECIO NUMBER(10,2), -- EJ. 12345678.90 CONSTRAINT
	 * 		ID_BICI_PK PRIMARY KEY(ID_BICI) );
	 * 
	 * 
	 * La anotación @Entity es una anotacion en JPA (Java Persistence API) que se
	 * utiliza para marcar una clase Java como una entidad de base de datos
	 * 
	 * La anotación @Table permite especificar el nombre correspondiente a una
	 * entidad de Java
	 * 
	 * La anotación @ID permite marcar un atributo de una entidad JAva como la clave
	 * primaria.
	 * 
	 * La anotación @Column permite especificar el nombre de la columna
	 * correspondiente al atributo en la tabla de base de datos relacional
	 */

	@Id
	@Column(name = "ID_BICI", columnDefinition = "NUMBER")
	private int idBici;
	
	@Column(name = "MARCA", columnDefinition = "NVARCHAR2(50)")
	private String marca;
	@Column(name = "MODELO", columnDefinition = "NVARCHAR2(30)")
	private String modelo;
	@Column(name = "TIPO", columnDefinition = "NVARCHAR2(30)")
	private String tipo;
	@Column(name = "COLOR", columnDefinition = "NVARCHAR2(30)")
	private String color;
	@Column(name = "RODADA", columnDefinition = "NUMBER")
	private int rodada;
	@Column(name = "MATERIAL", columnDefinition = "NVARCHAR2(30)")
	private String material;
	@Column(name = "PRECIO", columnDefinition = "NUMBER(10,2)")
	private double precio;

	public Bicicleta() {
	}

	public Bicicleta(int idBici, String marca, String modelo, String tipo, String color, int rodada, String material,
			double precio) {
		super();
		this.idBici = idBici;
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		this.color = color;
		this.rodada = rodada;
		this.material = material;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Bicicleta [idBici=" + idBici + ", marca=" + marca + ", modelo=" + modelo + ", tipo=" + tipo + ", color="
				+ color + ", rodada=" + rodada + ", material=" + material + ", precio=" + precio + "]";
	}

	public int getIdBici() {
		return idBici;
	}

	public void setIdBici(int idBici) {
		this.idBici = idBici;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getRodada() {
		return rodada;
	}

	public void setRodada(int rodada) {
		this.rodada = rodada;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
