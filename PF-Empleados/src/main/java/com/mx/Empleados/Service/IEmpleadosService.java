package com.mx.Empleados.Service;

import java.util.List;

import com.mx.Empleados.Entity.Empleados;

public interface IEmpleadosService {

	public Empleados guardar(Empleados empleado);
	
	public Empleados buscar(int idEmpleado);
	
	public Empleados editar(Empleados empleado);
	
	public Empleados eliminar(int idEmpleado);
	
	public List<Empleados> listar(); 
}
