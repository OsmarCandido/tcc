package com.sgbr.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.sgbr.model.Categoria;
import com.sgbr.model.Produto;
import com.sgbr.repository.Categorias;
import com.sgbr.service.CadastroProdutoService;
import com.sgbr.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 @Inject
	 private Categorias categorias;
	
	@Inject
	private CadastroProdutoService cadastroProdutoService;
	
	
	private Produto produto;
	
	private Categoria categoriaPai;
	
	private List<Categoria> categoriasRaizes;
	private List<Categoria> subcategorias;
	
	public CadastroProdutoBean() {
		produto = new Produto();
	}
	
	public void inicializar(){
		if(FacesUtil.isNotPostback()){
			categoriasRaizes = categorias.raizes();
			
			if(this.categoriaPai != null){
				carregarSubcategorias();
			}
		}
	}
				
	public void carregarSubcategorias(){
		subcategorias = categorias.subcategoriasDe(categoriaPai);
	}
	
	public void salvar() {
		System.out.println((this.produto.getIdProduto()));
		this.produto = cadastroProdutoService.salvar(this.produto);
		
		FacesUtil.addInfoMessage("Produto " + this.produto.getDescricao() + " cadastrado om sucesso!");

	}

	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
		
		if(this.produto != null){
			this.categoriaPai = this.produto.getCategoria().getCategoriaPai();
		}
	}

	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}
	
	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	
	public List<Categoria> getSubcategorias() {
		return subcategorias;
}
	public boolean isEditando(){
		return this.produto.getIdProduto() != null; 
	}
	
}