package com.sgbr.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgbr.model.Caixa;
import com.sgbr.model.FormaPagamento;
import com.sgbr.model.Funcionario;
import com.sgbr.model.ItemPedido;
import com.sgbr.model.Mesa;
import com.sgbr.model.Pedido;
import com.sgbr.model.Produto;
import com.sgbr.model.StatusMesa;
import com.sgbr.repository.Caixas;
import com.sgbr.repository.Funcionarios;
import com.sgbr.repository.Mesas;
import com.sgbr.repository.Produtos;
import com.sgbr.service.CadastroMesaService;
import com.sgbr.service.CadastroPedidoService;
import com.sgbr.service.EstoqueService;
import com.sgbr.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Mesa> mesas;
	private List<Caixa> caixas;
	private List<Funcionario> vendedores;

	private Long idProduto;

	private Produto produtoLinhaEditavel;

	@Inject
	private Funcionarios funcionarios;

	@Inject
	private Mesas mesas_repository;
	
	@Inject
	private Caixas caixas_repository;

	@Inject
	private Produtos produtos;

	@Inject
	private CadastroPedidoService cadastroPedidoService;

	@Inject
	private CadastroMesaService cadastroMesaService;

	@Inject
	EstoqueService estoqueService;
	
	private Caixa caixa;
	
	@Produces
	@PedidoEdicao
	private Pedido pedido;

	@Inject
	private Event<PedidoAlteradoEvent> pedidoAlteradoEvent;

	public CadastroPedidoBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			this.vendedores = this.funcionarios.vendedores();
			this.mesas = this.mesas_repository.mesasDisponiveis();
			this.caixas = this.caixas_repository.caixas();
					

			this.pedido.adicionarItemVazio();
			this.recalcularPedido();
		}
	}

	private void limpar() {
		pedido = new Pedido();
	}

	public void pedidoAlterado(@Observes PedidoAlteradoEvent event) {
		this.pedido = event.getPedido();
	}

	public void salvar() {

		this.pedido.removerItemVazio();
		try {
			if (this.pedido.isNovo()) {
				this.pedido.getMesa().setStatus(StatusMesa.OCUPADA);
				cadastroMesaService.salvar(this.pedido.getMesa());
			}
			this.pedido = this.cadastroPedidoService.salvar(this.pedido);
			FacesUtil.addInfoMessage("Pedido registrado com sucesso!");
			
		} finally {
			this.pedido.adicionarItemVazio();
		}
		this.pedidoAlteradoEvent.fire(new PedidoAlteradoEvent(this.pedido));
	}
	

	public void recalcularPedido() {
		if (this.pedido != null) {
			this.pedido.calcularComissao();
			this.pedido.recalcularValorTotal();
		}
	}

	public void carregarProdutoPorIdProduto() {

		if (this.idProduto != null) {
			produtoLinhaEditavel = produtos.porIdProduto(this.idProduto);
			this.carregarProdutoLinhaEditavel();
		}
	}

	public List<Produto> completarProduto(String descricao) {
		return this.produtos.porNome(descricao);
	}

	public void carregarProdutoLinhaEditavel() {
		ItemPedido item = this.pedido.getItens().get(0);

		if (this.produtoLinhaEditavel != null) {
			if (this.existeItemComProduto(this.produtoLinhaEditavel)) {
				FacesUtil.addErrorMessage("já existe item com o produto informado");
			} else {
				item.setProduto(this.produtoLinhaEditavel);
				item.setValorUnitario(this.produtoLinhaEditavel.getValorVenda());

				this.pedido.adicionarItemVazio();
				this.produtoLinhaEditavel = null;
				this.idProduto = null;
				this.pedido.calcularComissao();
				this.pedido.recalcularValorTotal();
			}
		}
	}

	public void atualizarQuantidade(ItemPedido item, int linha) {
		if (item.getQuantidade() < 1) {
			if (linha == 0) {
				item.setQuantidade(1);
			} else {
				this.getPedido().getItens().remove(linha);
			}
		}
		this.pedido.calcularComissao();
		this.pedido.recalcularValorTotal();
	}

	private boolean existeItemComProduto(Produto produto) {
		boolean existeItem = false;

		for (ItemPedido item : this.getPedido().getItens()) {
			if (produto.equals(item.getProduto())) {
				existeItem = true;
				break;
			}
		}
		return existeItem;
	}

	public FormaPagamento[] getFormaPagamento() {
		return FormaPagamento.values();
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public List<Funcionario> getVendedores() {
		return vendedores;
	}

	public List<Caixa> getCaixas() {
		return caixas;
	}

	public Produto getProdutoLinhaEditavel() {
		return produtoLinhaEditavel;
	}

	public void setProdutoLinhaEditavel(Produto produtoLinhaEditavel) {
		this.produtoLinhaEditavel = produtoLinhaEditavel;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public boolean isEditando() {
		return this.pedido.getIdPedido() != null;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
}