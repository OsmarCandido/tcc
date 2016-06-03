package com.sgbr.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgbr.model.Produto;
import com.sgbr.repository.Produtos;
import com.sgbr.repository.filter.ProdutoFilter;
import com.sgbr.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Produtos produtos;
	
	private ProdutoFilter filtro;
	private List<Produto> produtosFiltrados;
	
	
	private Produto produtoSelecionado;
	
	public PesquisaProdutosBean() {
		filtro = new ProdutoFilter();
	}
	
	public void pesquisar() {
		produtosFiltrados = produtos.filtrados(filtro);
	}
	
	@PostConstruct
	public void init(){
		produtosFiltrados = produtos.filtrados(filtro);
	}
	
	
	public void excluir(){
		produtos.remover(produtoSelecionado);
		produtosFiltrados.remove(produtoSelecionado);
		 
		FacesUtil.addInfoMessage("Produto: " + produtoSelecionado.getDescricao() + " excluído com sucesso");
	}
	
	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public ProdutoFilter getFiltro() {
		return filtro;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
	
	
}