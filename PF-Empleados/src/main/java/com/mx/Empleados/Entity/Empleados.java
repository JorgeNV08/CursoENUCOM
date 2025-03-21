package com.mx.Empleados.Entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="PF_EMPLEADOS")
@Data
public class Empleados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmpleado;
	private String nombre;
	private String apellidos;
	private String email;
	private Long telefono;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fechaContratacion;
	private double salario;
	private int idDepartamento;
	private int idTitTrabajo;

	
}
/*
 * CREATE TABLE PF_EMPLEADOS (
    ID_EMPLEADO INT AUTO_INCREMENT,
    NOMBRE VARCHAR(50),
    APELLIDOS VARCHAR(100),
    EMAIL VARCHAR(50) UNIQUE,
    TELEFONO BIGINT,
    FECHA_CONTRATACION DATE,
    SALARIO DOUBLE,
    ID_DEPARTAMENTO INT,
    ID_TIT_TRABAJO INT,
    PRIMARY KEY (ID_EMPLEADO),
    FOREIGN KEY (ID_DEPARTAMENTO) REFERENCES PF_DEPARTAMENTOS(ID_DEPARTAMENTO),
    FOREIGN KEY (ID_TIT_TRABAJO) REFERENCES PF_TITULOS_TRABAJO(ID_TIT_TRABAJO)
);
 * */