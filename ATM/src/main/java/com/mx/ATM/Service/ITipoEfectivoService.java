package com.mx.ATM.Service;

import java.util.List;

import com.mx.ATM.Entity.TipoEfectivo;


public interface ITipoEfectivoService {

public TipoEfectivo guardar(TipoEfectivo tipoEfectivo);
	
	public TipoEfectivo editar (TipoEfectivo tipoEfectivo);
	
	public TipoEfectivo eliminar (TipoEfectivo tipoEfectivo);
	
	public TipoEfectivo buscar(int idTipoEfectivo);
	
	public List<TipoEfectivo> listar();
}
