package com.sgbr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Table
public class Caixa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Pagamento pagamento;
	
	private Funcionario funcionario;
}

