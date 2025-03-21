package com.mx.Camaras.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Camaras.Dominio.Camara;
import com.mx.Camaras.Repositorio.ICamaraRepository;

@Service
public class ICamaraServiceImpl implements ICamaraService {

	@Autowired
	private ICamaraRepository repository;
	
	@Override
	public void guardar(Camara cam) {
		repository.save(cam);
		
	}

	@Override
	public void editar(Camara cam) {
		repository.save(cam);
		
	}

	@Override
	public void eliminar(int idCam) {
		repository.deleteById(idCam);
		
	}

	@Override
	public Camara buscar(int idCam) {
		return repository.findById(idCam).orElse(null);
	}

	@Override
	public List<Camara> listar() {
		return (List<Camara>) repository.findAll();
	}

}
