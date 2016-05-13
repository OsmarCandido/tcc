package com.sgbr.model;

public enum StatusPedido {
	ORCAMENTO("orçamento"),
	ABERTO("aberto"),
	EMITIDO("emitido"),
	CANCELADO("cancelado");
	
private String descricao;
	
	private StatusPedido(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
