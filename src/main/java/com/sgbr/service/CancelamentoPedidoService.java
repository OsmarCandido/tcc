package com.sgbr.service;

import javax.inject.Inject;

import com.sgbr.model.Pedido;
import com.sgbr.model.StatusMesa;
import com.sgbr.model.StatusPedido;
import com.sgbr.repository.Pedidos;
import com.sgbr.util.jpa.Transactional;

public class CancelamentoPedidoService {
	
	@Inject
	private Pedidos pedidos;
	
	@Inject
	private EstoqueService estoqueService;
	
	@Inject
	private CadastroMesaService cadastroMesaService;
	
	@Transactional
	public Pedido cancelar(Pedido pedido) {
		pedido = this.pedidos.porIdPedido(pedido.getIdPedido());
		
		if(pedido.isNaoCancelavel()){
			throw new NegocioException("pedido não pode ser cancelado no status " 
					+ pedido.getStatus().getDescricao() + ".");
		}
		
			this.estoqueService.retornarItensPedido(pedido);
		
		pedido.setStatus(StatusPedido.CANCELADO);
		
		pedido.getMesa().setStatus(StatusMesa.DISPONIVEL);
		cadastroMesaService.salvar(pedido.getMesa());
		
		pedido =  this.pedidos.guardar(pedido);
		
		return pedido;
	}

}
