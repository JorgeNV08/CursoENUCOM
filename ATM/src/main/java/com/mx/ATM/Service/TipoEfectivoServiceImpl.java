package com.mx.ATM.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ATM.Dao.ITipoEfectivoDao;
import com.mx.ATM.Entity.TipoEfectivo;

@Service
@Transactional
public class TipoEfectivoServiceImpl implements ITipoEfectivoService{

	@Autowired
	private ITipoEfectivoDao dao;
	
	@Override
	public TipoEfectivo guardar(TipoEfectivo tipoEfectivo) {
		return dao.save(tipoEfectivo);
	}

	@Override
	public TipoEfectivo editar(TipoEfectivo tipoEfectivo) {
		TipoEfectivo aux = this.buscar(tipoEfectivo.getIdTipoEfectivo());
		if(aux != null) {
			return dao.save(tipoEfectivo);
		}
		return null;
	}

	@Override
	public TipoEfectivo eliminar(TipoEfectivo tipoEfectivo) {
		TipoEfectivo aux = this.buscar(tipoEfectivo.getIdTipoEfectivo());
		if(aux != null) {
			dao.delete(tipoEfectivo);
			return aux;
		}
		return null;
	}

	@Override
	public TipoEfectivo buscar(int idTipoEfectivo) {
		return dao.findById(idTipoEfectivo).orElse(null);
	}

	@Override
	public List<TipoEfectivo> listar() {
		return dao.findAll(Sort.by(Direction.ASC,"idTipoEfectivo"));
	}

}
