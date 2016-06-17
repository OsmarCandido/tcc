package com.sgbr.repository.filter;

import java.io.Serializable;

import com.sgbr.model.Status;

public class PagamentoFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idPagamento;
	private String pedido;
	private Status status;

	public String getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(String idPagamento) {
		this.idPagamento = idPagamento == null ? null : idPagamento.toUpperCase();
	}

	public String getNome() {
		return pedido;
	}

	public void setNome(String pedido) {
		this.pedido = pedido;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}