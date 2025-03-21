package com.mx.ATM.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ATM_DENOMINACION")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Denominacion {
	
	@Id
	@Column(name = "ID_DENOMINACION")
	private int idDenominacion;
	
	@ManyToOne
	@JoinColumn(name = "TIPO_EFECTIVO")
	private TipoEfectivo tipoEfectivo;
	
	@ManyToOne
	@JoinColumn(name = "VALOR_NOMINAL")
	private ValorNominal valorNominal;
	
	@Column(name = "CANTIDAD_DISPONIBLE")
	private int cantidadDisponible;
	
	@Column(name = "FECHA_ACTUALIZACION")
	private LocalDateTime fechaActualizacion;
	
	@Column(name = "CONTADOR_DIARIO")
	private int contadorDiario;
	
	
	
	
	
}
