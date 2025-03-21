package com.mx.ATM.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ATM.Dao.IDenominacionDao;
import com.mx.ATM.Entity.Denominacion;

@Service
@Transactional
public class DenominacionServiceImpl implements IDenominacionService {

	@Autowired
	private IDenominacionDao dao;
	
	@Override
	public Denominacion guardar(Denominacion denominacion) {
		return dao.save(denominacion);
	}

	@Override
	public Denominacion editar(Denominacion denominacion) {
		Denominacion aux = this.buscar(denominacion.getIdDenominacion());
		if(aux != null) {
			return dao.save(denominacion);
		}
		return null;
	}

	@Override
	public Denominacion eliminar(Denominacion denominacion) {
		Denominacion aux = this.buscar(denominacion.getIdDenominacion());
		if(aux != null) {
			dao.delete(denominacion);
			return aux;
		}
		return null;
	}

	@Override
	public Denominacion buscar(int idDenominacion) {
		return dao.findById(idDenominacion).orElse(null);
	}

	@Override
	public List<Denominacion> listar() {
		return dao.findAll(Sort.by(Direction.ASC,"idDenominacion"));
	}

}
