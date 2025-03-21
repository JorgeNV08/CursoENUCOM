package com.mx.FuncionCine.Entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="FUNCION")
@Data
public class FuncionCine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFuncion;
	private int idSala;
	private String pelicula;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fechaHora;
	private double precio;
}
/*
 *CREATE TABLE FUNCION (
    ID_FUNCION NUMBER PRIMARY KEY,
    ID_SALA NUMBER,
    PELICULA NVARCHAR2(100),  -- Nombre de la película
    FECHA_HORA DATE,     -- Fecha y hora de la función
    PRECIO NUMBER(10,2) ,      -- Precio del boleto

    CONSTRAINT FK_FUNCION_SALA FOREIGN KEY (ID_SALA) REFERENCES SALA_CINE(ID_SALA)
);
 * */
 