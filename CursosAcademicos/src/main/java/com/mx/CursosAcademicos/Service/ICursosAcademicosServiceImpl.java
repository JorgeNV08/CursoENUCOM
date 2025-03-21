package com.mx.CursosAcademicos.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CursosAcademicos.Dao.ICursosAcademicosDao;
import com.mx.CursosAcademicos.Entity.CursosAcademicos;

@Service
@Transactional
public class ICursosAcademicosServiceImpl implements ICursosAcademicosService {

	@Autowired
	private ICursosAcademicosDao dao;
	
	@Override
	public CursosAcademicos guardar(CursosAcademicos cursos) {
		return dao.save(cursos);
	}

	@Override
	public CursosAcademicos editar(CursosAcademicos cursos) {
		CursosAcademicos aux = this.buscar(cursos.getIdCurso());
		if(aux != null) {
			return dao.save(cursos);
		}
		return null;
	}

	@Override
	public CursosAcademicos eliminar(CursosAcademicos cursos) {
		CursosAcademicos aux = this.buscar(cursos.getIdCurso());
		if(aux != null) {
			dao.delete(cursos);
			return aux;
		}
		return null;
	}

	@Override
	public CursosAcademicos buscar(int idCurso) {
		return dao.findById(idCurso).orElse(null);
	}

	@Override
	public List<CursosAcademicos> listar() {
		return dao.findAll();
	}

}
