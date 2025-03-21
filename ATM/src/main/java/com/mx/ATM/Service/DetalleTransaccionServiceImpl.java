package com.mx.ATM.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ATM.Dao.IDetalleTransaccionDao;
import com.mx.ATM.Entity.DetalleTransaccion;

@Service
@Transactional
public class DetalleTransaccionServiceImpl implements IDetalleTransaccionService{

	@Autowired
	private IDetalleTransaccionDao dao;
	
	@Override
	public DetalleTransaccion guardar(DetalleTransaccion detalleTransaccion) {
		return dao.save(detalleTransaccion);
	}

	@Override
	public DetalleTransaccion editar(DetalleTransaccion detalleTransaccion) {
		DetalleTransaccion aux = this.buscar(detalleTransaccion.getIdDetalle());
		if(aux != null) {
			return dao.save(detalleTransaccion);
		}
		return null;
	}

	@Override
	public DetalleTransaccion eliminar(DetalleTransaccion detalleTransaccion) {
		DetalleTransaccion aux = this.buscar(detalleTransaccion.getIdDetalle());
		if(aux != null) {
			dao.delete(detalleTransaccion);
			return aux;
		}
		return null;
	}

	@Override
	public DetalleTransaccion buscar(int idDetalleTransaccion) {
		return dao.findById(idDetalleTransaccion).orElse(null);
	}

	@Override
	public List<DetalleTransaccion> listar() {
		return dao.findAll(Sort.by(Direction.ASC,"idDetalleTransaccion"));
	}

}
