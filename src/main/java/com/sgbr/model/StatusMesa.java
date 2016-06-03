package com.sgbr.model;

public enum StatusMesa {
	DISPONIVEL("disponivel"), OCUPADA("ocupada");

	private String descricao;

	private StatusMesa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
