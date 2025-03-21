package com.mx.CursosAcademicos.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CursosAcademicos.Dao.IInscripcionDao;
import com.mx.CursosAcademicos.Entity.Inscripcion;

@Service
@Transactional
public class IInscripcionServiceImpl implements IInscripcionService{

	@Autowired
	private IInscripcionDao dao;
	
	@Override
	public Inscripcion guardar(Inscripcion insc) {
		return dao.save(insc);
	}

	@Override
	public Inscripcion editar(Inscripcion insc) {
		Inscripcion aux = this.buscar(insc.getIdInscripcion());
		if (aux != null) {
			return dao.save(insc);
		}
		return null;
	}

	@Override
	public Inscripcion eliminar(Inscripcion insc) {
		Inscripcion aux = this.buscar(insc.getIdInscripcion());
		if (aux != null) {
			dao.delete(insc);
			return aux;
		}
		return null;
	}

	@Override
	public Inscripcion buscar(int idInscripcion) {
		return dao.findById(idInscripcion).orElse(null);
	}

	@Override
	public List<Inscripcion> listar() {
		return dao.findAll(Sort.by(Direction.ASC,"idInscripcion"));
	}

}
