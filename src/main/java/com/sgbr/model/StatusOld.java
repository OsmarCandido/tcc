package com.sgbr.model;

public enum StatusOld {
	
	ABERTO ("Aberto"), FECHADO ("Fechado"), CANCELADO("Cancelado");	
	
	
private String descricao;
	
	private StatusOld(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}

