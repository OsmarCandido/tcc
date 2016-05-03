package com.sgbr.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgbr.model.Categoria;
import com.sgbr.model.Produto;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produto produto;
	
	// Gets

	public Produto getProduto() {
		return produto;
	}
	
	public Categoria[] getCategorias(){
		return Categoria.values();
	}

	// Sets

	
	
	// Metodos

	public CadastroProdutoBean() {
		produto = new Produto();
	}

	public void salvar() {
		
	}
}