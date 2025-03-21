package com.mx.CursosAcademicos.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Tabla hijo
@Entity
/*@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter*/
//@Table
public class Inscripcion {
/*
 * ID_INSCRIPCION	NUMBER
ID_CURSO	NUMBER
ID_ESTUDIANTE	NUMBER
FECHA_INSCRIPCION	DATE
CALIFICACION	NUMBER(5,2)
 * */
	@Id
    @Column(name = "ID_INSCRIPCION")
    private int idInscripcion;
    
    @Column(name = "ID_ESTUDIANTE")
    private int idEstudiante;
    
    @Column(name = "FECHA_INSCRIPCION")
    private Date fechaInscripcion;
    
    @Column(name = "CALIFICACION")
    private double calificacion;
    
    // Relación con CursosAcademicos
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CURSO", referencedColumnName = "ID_CURSO")
    private CursosAcademicos cursoAcademico;

	public Inscripcion() {
	}

	public Inscripcion(int idInscripcion, int idEstudiante, Date fechaInscripcion, double calificacion,
			CursosAcademicos idCurso) {
		this.idInscripcion = idInscripcion;
		this.idEstudiante = idEstudiante;
		this.fechaInscripcion = fechaInscripcion;
		this.calificacion = calificacion;
		this.cursoAcademico = idCurso;
	}

	@Override
	public String toString() {
		return "Inscripcion [idInscripcion=" + idInscripcion + ", idEstudiante=" + idEstudiante + ", fechaInscripcion="
				+ fechaInscripcion + ", calificacion=" + calificacion + ", idCurso=" + cursoAcademico + "]";
	}

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public CursosAcademicos getIdCurso() {
		return cursoAcademico;
	}

	public void setIdCurso(CursosAcademicos idCurso) {
		this.cursoAcademico = idCurso;
	}
	
	
    
	
	
}
