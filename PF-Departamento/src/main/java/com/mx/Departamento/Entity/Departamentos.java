package com.mx.Departamento.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="PF_DEPARTAMENTOS")
@Data
public class Departamentos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDepartamento;
	private String departamento;
}
/*
 * CREATE TABLE PF_DEPARTAMENTOS (
    ID_DEPARTAMENTO INT NOT NULL AUTO_INCREMENT,
    DEPARTAMENTO VARCHAR(150),
    PRIMARY KEY (ID_DEPARTAMENTO)
);
 * */
