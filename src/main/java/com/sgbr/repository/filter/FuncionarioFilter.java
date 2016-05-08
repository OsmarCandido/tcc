package com.sgbr.repository.filter;

import java.io.Serializable;

import com.sgbr.validation.IdFuncionario;

public class FuncionarioFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idFuncionario;
	private String descricao;

	@IdFuncionario
	public String getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdProduto(String idProduto) {
		this.idFuncionario = idFuncionario == null ? null : idProduto.toUpperCase();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}