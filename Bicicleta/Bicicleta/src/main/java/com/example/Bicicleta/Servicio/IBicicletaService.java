package com.example.Bicicleta.Servicio;

import java.util.List;

import com.example.Bicicleta.Dominio.Bicicleta;


// *******************PASO 4 CREAR NUESTROS CRUD

public interface IBicicletaService {

	public void guardar(Bicicleta bici);
	
	public void editar(Bicicleta bici);
	
	public void eliminar(int idBici);
	
	public Bicicleta buscar(int bici);
	
	public List<Bicicleta> listar();
}
