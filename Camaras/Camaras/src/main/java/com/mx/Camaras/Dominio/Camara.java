package com.mx.Camaras.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CAMARAS")
public class Camara {
/*
 * CREATE TABLE CAMARAS (
    ID_CAM NUMBER,       
    MARCA VARCHAR(100),             
    MODELO VARCHAR(100),                                                               
    ANO_FABRICACION INT,                                     
    MATERIAL VARCHAR(100),                   
    PESO NUMERIC,                     
    PRECIO DECIMAL(10,2),
    CONSTRAINT ID_CAM_PK PRIMARY KEY (ID_CAM)
);
 * */
	@Id
	@Column(name = "ID_CAM", columnDefinition = "NUMBER")
	private int idCam;
	 
	@Column(name = "MARCA", columnDefinition = "VARCHAR(100)")
	private String marca;
	@Column(name = "MODELO", columnDefinition = "VARCHAR(100)")
	private String modelo;
	@Column(name = "ANO_FABRICACION", columnDefinition = "NUMBER")
	private int ano_fabricacion;
	@Column(name = "MATERIAL", columnDefinition = "VARCHAR(100)")
	private String material;
	@Column(name = "PESO", columnDefinition = "NUMERIC")
	private int peso;
	@Column(name = "PRECIO", columnDefinition = "DECIMAL(10,2)")
	private double precio;
	
	public Camara() {
	}

	public Camara(int idCam, String marca, String modelo, int ano_fabricacion, String material, int peso,
			double precio) {
		this.idCam = idCam;
		this.marca = marca;
		this.modelo = modelo;
		this.ano_fabricacion = ano_fabricacion;
		this.material = material;
		this.peso = peso;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Camara [idCam=" + idCam + ", marca=" + marca + ", modelo=" + modelo + ", ano_fabricacion="
				+ ano_fabricacion + ", material=" + material + ", peso=" + peso + ", precio=" + precio + "]";
	}

	public int getIdCam() {
		return idCam;
	}

	public void setIdCam(int idCam) {
		this.idCam = idCam;
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

	public int getAno_fabricacion() {
		return ano_fabricacion;
	}

	public void setAno_fabricacion(int ano_fabricacion) {
		this.ano_fabricacion = ano_fabricacion;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
