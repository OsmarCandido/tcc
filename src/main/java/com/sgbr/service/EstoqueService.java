package com.sgbr.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sgbr.model.ItemPedido;
import com.sgbr.model.Pedido;
import com.sgbr.repository.Pedidos;
import com.sgbr.util.jpa.Transactional;

public class EstoqueService implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	Pedidos pedidos;
	
	@Transactional
	public void baixarItensEstoque(Pedido pedido) {
		pedido = this.pedidos.porIdPedido(pedido.getIdPedido());
		
		for(ItemPedido item : pedido.getItens()){
			item.getProduto().baixarEstoque(item.getQuantidade());
		}
	}
}
