package com.sgbr.repository.filter;

import java.io.Serializable;

import com.sgbr.model.Status;

public class CaixaFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idCaixa;
	private Status status;

	public String getIdCaixa() {
		return idCaixa;
	}

	public void setIdCaixa(String idCaixa) {
		this.idCaixa = idCaixa == null ? null : idCaixa.toUpperCase();
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}