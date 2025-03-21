package com.mx.FuncionCine.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.FuncionCine.Dao.IFunCineDao;
import com.mx.FuncionCine.Entity.FuncionCine;
import com.mx.FuncionCine.FeignClients.IBoletoFeign;
import com.mx.FuncionCine.Models.Sala;

@Service
public class FunCineImpl implements IFunCineService{

	@Autowired
	IFunCineDao dao;
	
	@Autowired
	IBoletoFeign salaFC;
	
	@Override
	public FuncionCine guardar(FuncionCine funcion) {
		return dao.save(funcion);
	}

	@Override
	public FuncionCine editar(FuncionCine funcion) {
		FuncionCine aux = this.buscar(funcion.getIdFuncion());
		if(aux!=null)
			return dao.save(funcion);
		return null;
	}

	@Override
	public FuncionCine eliminar(int idFuncion) {
		FuncionCine aux = this.buscar(idFuncion);
		if(aux!=null) {
			dao.deleteById(idFuncion);
			return aux;
		}
		return null;
	}

	@Override
	public FuncionCine buscar(int idFuncion) {
		return dao.findById(idFuncion).orElse(null);
	}

	@Override
	public List<FuncionCine> listar() {
		return dao.findAll(Sort.by(Direction.ASC,"idFuncion"));
	}
	
	//*************************SERVICIOS DE SALA
			// Metodos con FeignClient

	public List<Sala> listarSala() {
		return salaFC.getSalaCine();
	}
}
