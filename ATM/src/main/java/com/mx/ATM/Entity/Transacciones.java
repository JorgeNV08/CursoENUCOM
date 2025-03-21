package com.mx.ATM.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name ="ATM_TRANSACCIONES")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Transacciones {

	@Id
	@Column(name = "ID_TRANSACCION")
	private int idTransaccion;
	
	@ManyToOne
	@JoinColumn(name = "ID_CAJERO")
	private Cajero cajero;
	
	@Column(name = "MONTO_SOLICITADO")
	private Long montoSolicitado;
	@Column(name = "FECHA_TRANSACCION")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaTransaccion;
	@Column(name = "MONTO_ENTREGADO")
	private Long montoEntregado;
}
