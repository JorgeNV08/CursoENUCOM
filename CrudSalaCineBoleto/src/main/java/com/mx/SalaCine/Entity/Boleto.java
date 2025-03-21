package com.mx.SalaCine.Entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;

@Entity // Esta clase va a ser mapeada a una entidad de la base de datos por medio de
		// @Entity
//@Table(name = "BOLETO")
public class Boleto {
	/*
	 * CREATE TABLE BOLETO( 
	 * ID_BOLETO NUMBER, 
	 * NOM_PELICULA NVARCHAR2(100),
	 * CLASIFICACION NVARCHAR2(50), 
	 * NO_ASIENTO NVARCHAR2(5), 
	 * FECHA DATE, 
	 * SALA_ID NUMBER, 
	 * CONSTRAINT ID_BOLETO_PK PRIMARY KEY (ID_BOLETO),
	 * CONSTRAINT SALA_ID_FK FOREIGN KEY (SALA_ID) REFERENCES SALA_CINE(ID_SALA) );
	 * 
	 */
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBoleto;
	@Column
	private String nomPelicula;
	@Column
	private String clasificacion;
	@Column
	private String noAsiento;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyy-MM-dd")
	private Date fecha;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SALA_ID")
	private Sala salaId;

	public Boleto() {
	}

	public Boleto(Long idBoleto, String nomPelicula, String clasificacion, String noAsiento, Date fecha, Sala salaId) {
		this.idBoleto = idBoleto;
		this.nomPelicula = nomPelicula;
		this.clasificacion = clasificacion;
		this.noAsiento = noAsiento;
		this.fecha = fecha;
		this.salaId = salaId;
	}

	@Override
	public String toString() {
		return "Boleto [idBoleto=" + idBoleto + ", nomPelicula=" + nomPelicula + ", clasificacion=" + clasificacion
				+ ", noAsiento=" + noAsiento + ", fecha=" + fecha + ", salaId=" + salaId + "]";
	}

	public Long getIdBoleto() {
		return idBoleto;
	}

	public void setIdBoleto(Long idBoleto) {
		this.idBoleto = idBoleto;
	}

	public String getNomPelicula() {
		return nomPelicula;
	}

	public void setNomPelicula(String nomPelicula) {
		this.nomPelicula = nomPelicula;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getNoAsiento() {
		return noAsiento;
	}

	public void setNoAsiento(String noAsiento) {
		this.noAsiento = noAsiento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Sala getSalaId() {
		return salaId;
	}

	public void setSalaId(Sala salaId) {
		this.salaId = salaId;
	}

}
