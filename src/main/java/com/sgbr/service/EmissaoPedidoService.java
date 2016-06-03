package com.sgbr.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sgbr.model.Pedido;
import com.sgbr.model.StatusPedido;
import com.sgbr.repository.Pedidos;
import com.sgbr.util.jpa.Transactional;

public class EmissaoPedidoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	EstoqueService estoqueService;
	
	@Inject
	CadastroPedidoService cadastroPedidoService;
	
	@Inject
	private Pedidos pedidos;
	
	@Transactional
	public Pedido emitir(Pedido pedido) {
		pedido = this.cadastroPedidoService.salvar(pedido);
		
		if(pedido.isNaoFechavel()){
			throw new NegocioException("Pedido não pode ser fechado com status " 
					+ pedido.getStatus().getDescricao() + "."); 
		}
		
		//this.estoqueService.baixarItensEstoque(pedido);
		
		pedido.setStatus(StatusPedido.FECHADO);
		pedido = this.pedidos.guardar(pedido);
		
		return pedido;
	}
}
