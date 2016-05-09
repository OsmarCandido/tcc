package com.sgbr.repository.filter;

import java.io.Serializable;

public class FuncionarioFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idFuncionario;
	private String descricao;

	
	public String getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdProduto(String idProduto) {
		this.idFuncionario = idFuncionario == null ? null : idFuncionario.toUpperCase();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}