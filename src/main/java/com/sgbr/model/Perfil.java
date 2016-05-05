 package com.sgbr.model;

public enum Perfil {
	GARCOM("Garcom"), GERENTE("Gerente"), CAIXA("Caixa"), CHEF("Chef");


private String descricao;
	
	private Perfil(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}