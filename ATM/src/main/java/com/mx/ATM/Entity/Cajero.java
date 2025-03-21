package com.mx.ATM.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ATM_CAJERO")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Cajero {
	
	@Id
	@Column(name = "ID_CAJERO")
	private int idCajero;
	
	@Column(name = "SALDO_INICIAL")
	private Double saldoInicial;
	
	@Column(name = "FECHA_ACTUALIZACION")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaActualizacion;
	
}
