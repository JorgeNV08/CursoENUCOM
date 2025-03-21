package com.mx.ATM.Service;

import java.util.List;
import java.util.Map;

import com.mx.ATM.Entity.Cajero;
import com.mx.ATM.Entity.Transacciones;

public interface ICajeroService {

	public Cajero guardar(Cajero cajero);
	
	public Cajero editar (Cajero cajero);
	
	public Cajero eliminar (Cajero cajero);
	
	public Cajero buscar(int idCajero);
	
	public List<Cajero> listar();
	
	// Método para realizar el retiro de Efectivo
    public Map<String, Integer> retirarEfectivo(double monto);
    
    //Metodo para mostrar las transacciones
    public List<Transacciones> obtenerTransacciones();
	
}
