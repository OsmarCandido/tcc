package com.sgbr.model;

public enum FormaPagamento {
	
	DINHEIRO("Dinheiro"),
	CARTAO_CREDITO("cartão de crédito"),
	CARTAO_DEBITO("cartão de débito"),
	CHEQUE("cheque"),
	BOLETO_BANCARIO("boleto bancário"),
	DEPOSITO_BANCARIO("depósito bancário");
	
	private String descricao;
	
	FormaPagamento(String descricao){
		this.descricao = descricao;
	}
	
	public  String getDescricao(){
		return descricao;
	}
	
}
