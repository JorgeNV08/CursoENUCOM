package com.mx.Empleados.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.Empleados.Dao.IEmpleadosDao;
import com.mx.Empleados.Entity.Empleados;

@Service 
public class EmpleadosServImpl implements IEmpleadosService {

	@Autowired
	IEmpleadosDao dao;
	
	@Override
	public Empleados guardar(Empleados empleado) {
		return dao.save(empleado);
	}

	@Override
	public Empleados buscar(int idEmpleado) {
		return dao.findById(idEmpleado).orElse(null);
	}

	@Override
	public Empleados editar(Empleados empleado) {
		Empleados aux = this.buscar(empleado.getIdEmpleado());
		if(aux != null) {
			return dao.save(empleado);
		}
		return null;
	}

	@Override
	public Empleados eliminar(int idEmpleado) {
		Empleados aux = this.buscar(idEmpleado);
		if(aux != null) {
			dao.deleteById(idEmpleado);
			return aux;
		}
		return null;
	}

	@Override
	public List<Empleados> listar() {
		return dao.findAll(Sort.by(Direction.DESC,"idEmpleado"));
	}

}
