package com.mx.CursosAcademicos.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "CURSO_ACADEMICO")
/*@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter*/

public class CursosAcademicos {
/*
 * ID_CURSO	NUMBER
NOMBRE_CURSO	NVARCHAR2(100 CHAR)
PROFESOR	NVARCHAR2(100 CHAR)
DURACION_HORAS	NUMBER
CATEGORIA	NVARCHAR2(50 CHAR)
 * */
	
	@Id
    @Column(name = "ID_CURSO")
    private int idCurso;
    
    @Column(name = "NOMBRE_CURSO")
    private String nombreCurso;
    
    @Column(name = "PROFESOR")
    private String profesor;
    
    @Column(name = "DURACION_HORAS")
    private int duracionHoras;
    
    @Column(name = "CATEGORIA")
    private String categoria;
	
	//Referencia a la Otra Tabla
    @OneToMany(mappedBy = "cursoAcademico", cascade = CascadeType.ALL)
	List<Inscripcion> list = new ArrayList<>();

	public CursosAcademicos() {
	}

	public CursosAcademicos(int idCurso, String nombreCurso, String profesor, int duracionHoras, String categoria,
			List<Inscripcion> list) {
		this.idCurso = idCurso;
		this.nombreCurso = nombreCurso;
		this.profesor = profesor;
		this.duracionHoras = duracionHoras;
		this.categoria = categoria;
		this.list = list;
	}

	@Override
	public String toString() {
		return "CursosAcademicos [idCurso=" + idCurso + ", nombreCurso=" + nombreCurso + ", profesor=" + profesor
				+ ", duracionHoras=" + duracionHoras + ", categoria=" + categoria + ", list=" + list + "]";
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public int getDuracionHoras() {
		return duracionHoras;
	}

	public void setDuracionHoras(int duracionHoras) {
		this.duracionHoras = duracionHoras;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
}
