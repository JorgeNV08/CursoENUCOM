package com.mx.Camaras.Servicio;

import java.util.List;

import com.mx.Camaras.Dominio.Camara;


public interface ICamaraService {
	
	public void guardar(Camara cam);
	
	public void editar(Camara cam);
	
	public void eliminar(int idCam);
	
	public Camara buscar(int idCam);
	
	public List<Camara> listar();
}
