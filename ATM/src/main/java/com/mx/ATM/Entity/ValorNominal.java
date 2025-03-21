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
@Table(name = "ATM_VALOR_NOMINAL")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ValorNominal {

	@Id
	@Column(name = "ID_VALOR_NOM")
	private int idValorNom;
	
	@Column(name = "VALOR")
	private int valor;
}
