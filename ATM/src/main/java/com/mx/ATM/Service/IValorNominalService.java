package com.mx.ATM.Service;

import java.util.List;

import com.mx.ATM.Entity.ValorNominal;

public interface IValorNominalService {

	public ValorNominal guardar(ValorNominal valorNominal);
	
	public ValorNominal editar (ValorNominal valorNominal);
	
	public ValorNominal eliminar (ValorNominal valorNominal);
	
	public ValorNominal buscar(int idValorNominal);
	
	public List<ValorNominal> listar();
}
