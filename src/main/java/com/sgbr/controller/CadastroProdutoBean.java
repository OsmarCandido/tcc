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
		}
	}
				
	public void carregarSubcategorias(){
		subcategorias = categorias.subcategoriasDe(categoriaPai);
	}
	
	public void salvar() {
		System.out.println("Categoria: " + categoriaPai.getDescricao());
		System.out.println("Subcategoria: " + produto.getDescricao());
		System.out.println("id do produto: " + produto.getIdProduto());
		this.produto = cadastroProdutoService.salvar(this.produto);

	}

	public Produto getProduto() {
		return produto;
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

	
}