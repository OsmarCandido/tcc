package com.sgbr.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgbr.model.Categoria;
import com.sgbr.model.Produto;
import com.sgbr.repository.Categorias;
import com.sgbr.service.CadastroProdutoService;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Categorias categorias;
	
	@Inject
	private CadastroProdutoService cadastroProdutoService;
    private Produto produto;
	private Categoria categoria;
	private List<Categoria> categoriasRaizes;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void inicializar() {
//
//		if (FacesUtil.isNotPostback()) {
//			categoriasRaizes = categorias.raizes();
//
//			if (this.categoriaPai != null) {
//				carregarSubcategorias();
//			}
//		}
//	}
//
//	public void carregarSubcategorias() {
//		subcategorias = categorias.subcategoriasDe(categoriaPai);
//	}
//
//	private void limpar() {
//		produto = new Produto();
//		categoriaPai = null;
//		subcategorias = new ArrayList<>();
//	}
//
//	public void salvar() {
//		this.produto = cadastroProdutoService.salvar(this.produto);
//		limpar();
//
//		FacesUtil.addErrorMessage("Produto salvo com sucesso!");
//	}
//
//	public Produto getProduto() {
//		return produto;
//	}
//
//	public void setProduto(Produto produto) {
//		this.produto = produto;
//
//		if (this.produto != null) {
//			this.categoriaPai = this.produto.getCategoria().getcategoriaPai();
//		}
//	}
//
//	public List<Categoria> getCategoriasRaizes() {
//		return categoriasRaizes;
//	}
//
//	@Nonnull
//	public Categoria getCategoriaPai() {
//		return categoriaPai;
//	}
//
//	public void setCategoriaPai(Categoria categoriaPai) {
//		this.categoriaPai = categoriaPai;
//	}
//
//	public List<Categoria> getSubcategorias() {
//		return subcategorias;
//	}
//
//	public boolean isEditando() {
//		return this.produto.getIdProduto() != null;
//	}
//
//}
