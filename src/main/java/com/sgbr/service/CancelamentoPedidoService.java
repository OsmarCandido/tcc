package com.sgbr.service;

import javax.inject.Inject;

import com.sgbr.model.Pedido;
import com.sgbr.model.StatusPedido;
import com.sgbr.repository.Pedidos;
import com.sgbr.util.jpa.Transactional;

public class CancelamentoPedidoService {
	
	@Inject
	private Pedidos pedidos;
	
	@Inject
	private EstoqueService estoqueService;
	
	@Transactional
	public Pedido cancelar(Pedido pedido) {
		this.pedidos.porIdPedido(pedido.getIdPedido());
		
		if(pedido.isNaoCancelavel()){
			throw new NegocioException("pedido não pode ser cancelado no status " 
					+ pedido.getStatus().getDescricao() + ".");
		}
		
		if(pedido.isFechado()){
			this.estoqueService.retornarItensPedido(pedido);
		}
		
		pedido.setStatus(StatusPedido.CANCELADO);
		
		pedido =  this.pedidos.guardar(pedido);
		
		return pedido;
	}

}
