package com.sgbr.model;

public enum StatusPedido {
	ABERTO("aberto"),
	FECHADO("fechado"),
	CANCELADO("cancelado"),
	PAGO("pago");
	
private String descricao;
	
	private StatusPedido(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
