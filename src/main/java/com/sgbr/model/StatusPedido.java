package com.sgbr.model;

public enum StatusPedido {
	ORCAMENTO("orçamento"),
	ABERTO("aberto"),
	FECHADO("fechado"),
	CANCELADO("cancelado");
	
private String descricao;
	
	private StatusPedido(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
