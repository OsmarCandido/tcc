package com.sgbr.repository.filter;

import java.io.Serializable;

import com.sgbr.validation.IdProduto;

public class ProdutoFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idProduto;
	private String descricao;

	@IdProduto
	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto == null ? null : idProduto.toUpperCase();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}