package com.sgbr.model;

public enum Status {
	
	ABERTO ("Aberto"), FECHADO ("Fechado"), CANCELADO("Cancelado");	
	
	
private String descricao;
	
	private Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}

