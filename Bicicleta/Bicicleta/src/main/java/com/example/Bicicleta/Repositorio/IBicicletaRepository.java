package com.example.Bicicleta.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Bicicleta.Dominio.Bicicleta;

//*******************PASO 3 CREAR EL REPOSITORIO QUE EXTIENDA CRUDREPOSITTORY

@Repository
public interface IBicicletaRepository extends CrudRepository<Bicicleta, Integer>{
	
	
}
