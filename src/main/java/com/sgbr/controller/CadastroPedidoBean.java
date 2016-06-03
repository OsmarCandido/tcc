package com.sgbr.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgbr.model.Funcionario;
import com.sgbr.model.ItemPedido;
import com.sgbr.model.Mesa;
import com.sgbr.model.Pagamento;
import com.sgbr.model.Pedido;
import com.sgbr.model.Produto;
import com.sgbr.model.StatusPedido;
import com.sgbr.repository.Funcionarios;
import com.sgbr.repository.Mesas;
import com.sgbr.repository.Produtos;
import com.sgbr.service.CadastroPedidoService;
import com.sgbr.service.EstoqueService;
import com.sgbr.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Funcionarios funcionarios;
	
	@Inject
	private Mesas mesas_repository;
	
	@Inject
	private Produtos produtos;

	@Inject
	private CadastroPedidoService cadastroPedidoService;
	
	@Inject
	EstoqueService estoqueService;
	
	@Produces
	@PedidoEdicao
	private Pedido pedido;
	
	private List<Mesa> mesas;
	private List<Funcionario> vendedores;

	private Long idProduto;

	private Produto produtoLinhaEditavel;
	
	@Inject
	private Event<PedidoAlteradoEvent> pedidoAlteradoEvent;
	
	public CadastroPedidoBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			this.vendedores = this.funcionarios.vendedores();
			this.mesas = this.mesas_repository.mesas();
			
			this.pedido.adicionarItemVazio();
			this.recalcularPedido();
		}
	}

	private void limpar() {
		pedido = new Pedido();
	}
	
	public void pedidoAlterado(@Observes PedidoAlteradoEvent event){
		this.pedido = event.getPedido();
	}
	
	public void salvar() {

		this.pedido.removerItemVazio();
		try{
			this.pedido = this.cadastroPedidoService.salvar(this.pedido);
			FacesUtil.addInfoMessage("Pedido salvo com sucesso!");
			
		}finally{
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

		System.out.println("carregando Produto Por IdProduto");
		if (this.idProduto != null) {
			System.out.println("IdProduto nao esta vazio");
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

	public Pagamento[] getPagamento() {
		return Pagamento.values();
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
	
	public boolean isEditando(){
		return this.pedido.getIdPedido() != null; 
	}
	
}