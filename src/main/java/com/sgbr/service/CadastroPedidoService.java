package com.sgbr.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.sgbr.model.Pedido;
import com.sgbr.model.Status;
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
			pedido.setStatus(Status.ABERTO);
		}
		
		pedido = this.pedidos.guardar(pedido);
		return pedido;
	}
	
}