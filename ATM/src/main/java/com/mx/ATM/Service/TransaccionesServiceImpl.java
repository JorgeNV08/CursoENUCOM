package com.mx.ATM.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ATM.Dao.ITransaccionesDao;
import com.mx.ATM.Entity.Transacciones;

@Service
@Transactional
public class TransaccionesServiceImpl implements ITransaccionesService{

	@Autowired
	private ITransaccionesDao dao;
	
	@Override
	public Transacciones guardar(Transacciones transaccion) {
		return dao.save(transaccion);
	}

	@Override
	public Transacciones editar(Transacciones transaccion) {
		Transacciones aux = this.buscar(transaccion.getIdTransaccion());
		if(aux != null) {
			return dao.save(transaccion);
		}
		return null;
	}

	@Override
	public Transacciones eliminar(Transacciones transaccion) {
		Transacciones aux = this.buscar(transaccion.getIdTransaccion());
		if(aux != null) {
			dao.delete(transaccion);
			return aux;
		}
		return null;
	}

	@Override
	public Transacciones buscar(int idTransaccion) {
		return dao.findById(idTransaccion).orElse(null);
	}

	@Override
	public List<Transacciones> listar() {
		return dao.findAll(Sort.by(Direction.ASC,"idTransaccion"));
	}

}
