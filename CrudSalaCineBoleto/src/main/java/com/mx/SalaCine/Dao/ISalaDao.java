package com.mx.SalaCine.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.SalaCine.Entity.Sala;
import java.util.List;


@Repository
public interface ISalaDao extends JpaRepository<Sala, Long>{

	//CREAR METODOS PERSONALIZADOS CON "PALABRAS CLAVE" O CON LA ANOTACIÓN "@Query"
	
	//Metodo que buscará una sala por CATEGORIA
	@Query (nativeQuery = true,
			value = "SELECT ID_SALA, NO_ASIENTOS, TIPO_PANTALLA, CATEGORIA"
					+ "FROM SALA_CINE"
					+ "WHERE UPPER(CATEGORIA) = UPPER(:CATEGORIA)"
					+ "ORDER BY ID_SALA ASC;")
	public List<Sala> findByCategoria(String categoria);
	
	
	//Metodo personalizado con palabras clave
	public List<Sala> findByCategoriaIgnoringCaseOrderByIdSala(String categoria);
	
	public Sala findByIdSala(Long idSala);
	
}
