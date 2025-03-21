package com.mx.Departamento.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.Departamento.Dao.IDepartamentosDao;
import com.mx.Departamento.Entity.Departamentos;

@Service
public class DepServImpl implements IDepService {

	@Autowired
	IDepartamentosDao dao;
	
	@Override
	public Departamentos guardar(Departamentos departamento) {
		return dao.save(departamento);
	}

	@Override
	public Departamentos buscar(int idDepartamento) {
		return dao.findById(idDepartamento).orElse(null);
	}

	@Override
	public Departamentos editar(Departamentos departamento) {
		Departamentos aux = this.buscar(departamento.getIdDepartamento());
		if(aux!=null) {
			return dao.save(departamento);
		}
		return null;
	}

	@Override
	public Departamentos eliminar(int idDepartamento) {
		Departamentos aux = this.buscar(idDepartamento);
		if(aux!=null) {
			dao.deleteById(idDepartamento);
			return aux;
		}
		return null;
	}

	@Override
	public List<Departamentos> listar() {
		return dao.findAll(Sort.by(Direction.ASC,"idDepartamento"));
	}

}
