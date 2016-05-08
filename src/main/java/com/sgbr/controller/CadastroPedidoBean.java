package com.sgbr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.sgbr.model.Pagamento;
import com.sgbr.model.Pedido;
import com.sgbr.service.CadastroPedidoService;
import com.sgbr.util.jsf.FacesUtil;

@Named
@RequestScoped

public class CadastroPedidoBean {

	private List<Integer> itens;
	private Object pedido;
	private Object cadastroPedidoService;

	public CadastroPedidoBean() {

		itens = new ArrayList<>();
		itens.add(1);
	}
		
	public Pagamento[] getPagamento(){
		return Pagamento.values();
	}

	public void salvar() {
		this.pedido = ((CadastroPedidoService) this.cadastroPedidoService).salvar((Pedido) this.pedido);
		
		FacesUtil.addInfoMessage("Pedido salvo com sucesso!");
	}
	
	public List<Integer> getItens() {
		return itens;
	}
}