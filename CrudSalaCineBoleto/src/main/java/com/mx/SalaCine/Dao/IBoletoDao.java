package com.mx.SalaCine.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.SalaCine.Entity.Boleto;

@Repository
public interface IBoletoDao extends JpaRepository<Boleto, Long>{

	//Metodos personalizados
	
	//Obtener los Boletos por Nombre de Pelicula
	@Query(nativeQuery = true,
			value ="SELECT ID_BOLETO, NOM_PELICULA, CLASIFICACION, NO_ASIENTO, FECHA, SALA_ID"
					+ "FROM BOLETO"
					+ "WHERE UPPER(NOM_PELICULA) LIKE '%'|| UPPER(?) ||'%'")
	public List<Boleto> findByNomPelicula(String nomPelicula);
	
	@Query(nativeQuery = true,
			value ="SELECT ID_BOLETO, NOM_PELICULA, CLASIFICACION, NO_ASIENTO, FECHA, SALA_ID"
					+ "FROM BOLETO"
					+ "WHERE UPPER(CLASIFICACION) = UPPER(:CLASIFICACION)")
	public List<Boleto> findByClasificacion(String clasificacion);
}
