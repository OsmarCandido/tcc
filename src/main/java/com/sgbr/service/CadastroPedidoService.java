package com.sgbr.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.sgbr.model.Pedido;
import com.sgbr.model.StatusPedido;
import com.sgbr.repository.Pedidos;
import com.sgbr.util.jpa.Transactional;

public class CadastroPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pedidos pedidos;
	
	@Transactional
	public Pedido salvar(Pedido pedido) {
		if (pedido.isNovo()) {
			pedido.setDataCriacao(new Date());
			pedido.setStatus(StatusPedido.ABERTO);
		}
		
		pedido.recalcularValorTotal();
		
		if(pedido.getItens().isEmpty()){
			throw new NegocioException("Pedido deve conter pelo menos um item");
		}
		if (pedido.isValorTotalNegativo()) {
			throw new NegocioException("Valor total do pedido não pode ser negativo.");
		}
		
		pedido = this.pedidos.guardar(pedido);
		return pedido;
	}
	
}