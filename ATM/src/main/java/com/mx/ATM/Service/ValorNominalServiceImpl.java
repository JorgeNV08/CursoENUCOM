package com.mx.ATM.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ATM.Dao.IValorNominalDao;
import com.mx.ATM.Entity.ValorNominal;

@Service
@Transactional
public class ValorNominalServiceImpl implements IValorNominalService {

	@Autowired
	private IValorNominalDao dao;
	
	@Override
	public ValorNominal guardar(ValorNominal valorNominal) {
		return dao.save(valorNominal);
	}

	@Override
	public ValorNominal editar(ValorNominal valorNominal) {
		ValorNominal aux = this.buscar(valorNominal.getIdValorNom());
		if(aux != null) {
			return dao.save(valorNominal);
		}
		return null;
	}

	@Override
	public ValorNominal eliminar(ValorNominal valorNominal) {
		ValorNominal aux = this.buscar(valorNominal.getIdValorNom());
		if(aux != null) {
			dao.delete(valorNominal);
			return aux;
		}
		return null;

	}

	@Override
	public ValorNominal buscar(int idValorNominal) {
		return dao.findById(idValorNominal).orElse(null);
	}

	@Override
	public List<ValorNominal> listar() {
		return dao.findAll(Sort.by(Direction.ASC,"idValorNominal"));
	}

}
