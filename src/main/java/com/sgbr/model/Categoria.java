package com.sgbr.model;

public enum Categoria {
	BEBIDA ("Bebida"), COMIDA ("Comida");

  private String descricao;
	
	private Categoria(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
