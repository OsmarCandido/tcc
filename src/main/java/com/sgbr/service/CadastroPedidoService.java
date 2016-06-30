package com.sgbr.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.sgbr.model.Caixa;
import com.sgbr.model.Pagamento;
import com.sgbr.model.Pedido;
import com.sgbr.model.StatusPedido;
import com.sgbr.repository.Caixas;
import com.sgbr.repository.Pedidos;
import com.sgbr.util.jpa.Transactional;

public class CadastroPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pedidos pedidos;
	
	@Inject
	private Caixa caixa;

	@Inject
	EstoqueService estoqueService;
	
	@Inject
	RegistraPagamentoService registraPagamentoService;
	
	@Inject
	CadastroCaixaService cadastroCaixaService;

	@Transactional
	public Pedido salvar(Pedido pedido) {
		if (pedido.isNovo()) {
			pedido.setDataCriacao(new Date());
			pedido.setStatus(StatusPedido.ABERTO);
		}
		
		System.out.println("caixa no pedido = " + pedido.getCaixa());
		System.out.println("operador no pedido = " + pedido.getOperador().getNome());
		
		pedido.recalcularValorTotal();

		if (pedido.isNaoAlteravel() && pedido.isNaoAguardandoPagamento()) {
			throw new NegocioException(
					"Pedido não pode ser alterado no status " + pedido.getStatus().getDescricao() + ".");
		}

		if (pedido.getItens().isEmpty()) {
			throw new NegocioException("Pedido deve conter pelo menos um item");
		}

		if (pedido.isValorTotalNegativo()) {
			throw new NegocioException("Valor total do pedido não pode ser negativo.");
		}

		if (pedido.isFechado()) {
			Pagamento pagamento = new Pagamento();
			
			pagamento.setPedido(pedido);
			pagamento.setForma(pedido.getPagamento());
			pagamento.setValor(pedido.getValorTotal());
			pagamento.setCaixa(pedido.getCaixa());
			
			registraPagamentoService.salvar(pagamento);
			
			pedido.setStatus(StatusPedido.PAGO);
		}

		if (!pedido.isNovo()) {
			this.estoqueService.retornarItensPedido(pedido);
		}
		
		pedido = this.pedidos.guardar(pedido);

		this.estoqueService.baixarItensEstoque(pedido);

		return pedido;
	}

}