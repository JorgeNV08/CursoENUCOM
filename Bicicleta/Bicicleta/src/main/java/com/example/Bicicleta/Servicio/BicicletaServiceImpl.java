package com.example.Bicicleta.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bicicleta.Dominio.Bicicleta;
import com.example.Bicicleta.Repositorio.IBicicletaRepository;

/*
 * La anotación @Service 
 * */

//*******************PASO 5 CREAR NUESTROS METODOS QUE IMPLEMENTAN EL IBICICLETASERVICE Y DARLE ANOTACION @SERVICE

@Service
public class BicicletaServiceImpl implements IBicicletaService {

	/*
	 * INYECCION DE DEPENDENCIAS La anotación @Autowired es una anotacion en Spring
	 * que se utiliza para inyectar automaticamente una dependencia en un componente
	 * de la aplicación
	 *
	 * 
	 */
	 
//*******************PASO 6 CREAR ANOTACIÓN AUTOWIRED
	@Autowired
	private IBicicletaRepository repository;
	
//*******************PASO 7 editar nuestros metodos
	
	@Override
	public void guardar(Bicicleta bici) {
		repository.save(bici);

	}

	@Override
	public void editar(Bicicleta bici) {
		repository.save(bici);
	}

	@Override
	public void eliminar(int idBici) {
		repository.deleteById(idBici);

	}

	@Override
	public Bicicleta buscar(int idBici) {
		return repository.findById(idBici).orElse(null);
	}

	@Override
	public List<Bicicleta> listar() {
		return (List<Bicicleta>) repository.findAll();
	}

}
