package com.sgbr.model;

public enum FormaPagamento {
    DINHEIRO ("Dinheiro"), CARTAO ("Cartao");  

private String descricao;
	
	private FormaPagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
