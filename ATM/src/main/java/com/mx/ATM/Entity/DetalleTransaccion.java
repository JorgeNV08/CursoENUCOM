package com.mx.ATM.Entity;

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
@Table(name = "ATM_DETALLE_TRANSACCION")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class DetalleTransaccion {
	
	@Id
	@Column(name = "ID_DETALLE")
	private int idDetalle;
	
	@ManyToOne
	@JoinColumn(name = "ID_TRANSACCION")
	private Transacciones transaccion;
	
	@ManyToOne
	@JoinColumn(name="ID_DENOMINACION")
	private Denominacion denominacion;
	
	@Column(name ="CANTIDAD_ENTREGADA")
	private Double cantidadEntregada;
	
}
