package com.sgbr.repository.filter;

import java.io.Serializable;

import com.sgbr.model.Status;

public class MesaFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idMesa;
	private String nome;
	private Status status;

	public String getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(String idMesa) {
		this.idMesa = idMesa == null ? null : idMesa.toUpperCase();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}