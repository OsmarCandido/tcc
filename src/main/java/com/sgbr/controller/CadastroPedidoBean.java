package com.sgbr.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgbr.model.Funcionario;
import com.sgbr.model.ItemPedido;
import com.sgbr.model.Pagamento;
import com.sgbr.model.Pedido;
import com.sgbr.model.Produto;
import com.sgbr.repository.Funcionarios;
import com.sgbr.repository.Produtos;
import com.sgbr.service.CadastroPedidoService;
import com.sgbr.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Funcionarios funcionarios;
	
	@Inject
	private Produtos produtos;
	
	@Inject
	private CadastroPedidoService cadastroPedidoService;

	@Inject
	private Pedido pedido;

	private List<Funcionario> vendedores;
	
	private Produto produtoLinhaEditavel;

	public CadastroPedidoBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			this.vendedores = this.funcionarios.vendedores();
			
			this.pedido.adicionarItemVazio();
			
			this.recalcularPedido();
		}
	}

	private void limpar() {
		pedido = new Pedido();
	}

	public void salvar() {
		this.pedido = this.cadastroPedidoService.salvar(this.pedido);

		FacesUtil.addInfoMessage("Pedido salvo com sucesso!");
	}

	public void recalcularPedido() {
		if (this.pedido != null) {
			this.pedido.recalcularValorTotal();
		}
	}
	
	public List<Produto> completarProduto(String descricao){
		return this.produtos.porNome(descricao);
	}
	
	public void carregarProdutoLinhaEditavel(){
		ItemPedido item = this.pedido.getItens().get(0);
		
		if(this.produtoLinhaEditavel != null){
			item.setProduto(this.produtoLinhaEditavel);
			item.setValorUnitario(this.produtoLinhaEditavel.getValorVenda());
			
			this.pedido.adicionarItemVazio();
			this.produtoLinhaEditavel = null;
			
			this.pedido.recalcularValorTotal();
		}
	}
	
	public Pagamento[] getPagamento() {
		return Pagamento.values();
	}

	public Pedido getPedido() {
		return pedido;
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
	
	
}