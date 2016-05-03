package com.sgbr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.sgbr.model.Pagamento;
import com.sgbr.service.NegocioException;

@Named
@RequestScoped

public class CadastroPedidoBean {

	private List<Integer> itens;

	public CadastroPedidoBean() {

		itens = new ArrayList<>();
		itens.add(1);
	}
		
	public Pagamento[] getPagamento(){
		return Pagamento.values();
	}

	public void salvar() {
		throw new NegocioException("Pedido não pode ser salvo, pois ainda não foi implementado.");
	}
	
	public List<Integer> getItens() {
		return itens;
	}
}