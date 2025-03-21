package com.mx.Proveedores.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.Proveedores.Entity.Proveedores;

@Repository
public interface IProveedoresDao extends JpaRepository<Proveedores,Integer> {
	
	//CREAR METODOS PERSONALIZADOS CON "PALABRAS CLAVE" O CON LA ANOTACIÓN "@Query"
	
	//Metodo que buscará una Tienda mediante tiendaId
	
	@Query(nativeQuery = true,
			value= "SELECT ID, NOMBRE, CONTACTO, EMPRESA, TIENDA_ID "
					+ "FROM PROVEEDORES "
					+ "WHERE TIENDA_ID = :tiendaId "
					+ "ORDER BY TIENDA_ID ASC")
	public List<Proveedores>  findByTiendaId(@Param("tiendaId") int tiendaId);
	
	
	
}
