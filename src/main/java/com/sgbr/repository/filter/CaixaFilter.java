package com.sgbr.repository.filter;

import java.io.Serializable;

public class CaixaFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idCaixa;

	public String getIdCaixa() {
		return idCaixa;
	}

	public void setIdCaixa(String idCaixa) {
		this.idCaixa = idCaixa == null ? null : idCaixa.toUpperCase();
	}
	
	
}