package com.mx.ATM.Entity;

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
@Table(name = "ATM_TIPO_EFECTIVO")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class TipoEfectivo {
	
	@Id
	@Column(name ="ID_TIPO_EFECTIVO")
	private int idTipoEfectivo;
	
	@Column(name="TIPO")
	private String tipo;
	
}
