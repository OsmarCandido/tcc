package com.sgbr.model;

public enum StatusCaixa {
	ABERTO("aberto"), PARALISADO("paralisado"), FECHADO("fechado"), ;

	private String descricao;

	private StatusCaixa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
