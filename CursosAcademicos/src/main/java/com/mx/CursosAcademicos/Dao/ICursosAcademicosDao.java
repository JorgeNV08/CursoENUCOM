package com.mx.CursosAcademicos.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.CursosAcademicos.Entity.CursosAcademicos;

@Repository
public interface ICursosAcademicosDao extends JpaRepository<CursosAcademicos, Integer>{
	

	//Obtener los Cursos
	
	//Metodo que buscara Curso por inscripción
	@Query(nativeQuery = true,
			value = "SELECT ID_CURSO, NOMBRE_CURSO, PROFESOR, DURACION_HORAS, CATEGORIA "
					+ "FROM CURSO_ACADEMICO"
					+ "WHERE UPPER(PROFESOR) "
					+ "LIKE UPPER('%' || :profesor || '%')"
					+ "ORDER BY NOMBRE_CURSO ASC")
	public List <CursosAcademicos> findByProfesor(String profesor);
	
}

