package com.sgbr.model;

public enum Pagamento {
    DINHEIRO ("Dinheiro"), CARTAO ("Cartao");  

private String descricao;
	
	private Pagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
