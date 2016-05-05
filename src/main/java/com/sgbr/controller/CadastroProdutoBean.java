package com.sgbr.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.sgbr.model.Categoria;
import com.sgbr.model.Produto;
import com.sgbr.service.CadastroProdutoService;
import com.sgbr.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroProdutoService cadastroProdutoService;
	
	private Produto produto;
	
	public CadastroProdutoBean() {
		limpar();
	}
	
	public void inicializar() {
	}
	
	private void limpar() {
		produto = new Produto();
	}
	
	public void salvar() {
		this.produto = cadastroProdutoService.salvar(this.produto);
		FacesUtil.addInfoMessage("Produto salvo com sucesso!");
	}
	
	
	public boolean isEditando() {
		return this.produto.getIdProduto() != null;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	// Gets
	
	public Categoria[] getCategorias(){
		return Categoria.values();
	}

	// Sets

}
