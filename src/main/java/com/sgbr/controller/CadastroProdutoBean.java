package com.sgbr.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgbr.model.Produto;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
    private Produto produto;
		
	public Produto getProduto() {
		return produto;
	}
	
	public CadastroProdutoBean() {
		produto = new Produto();
	}

	public void salvar() {
		
	}
	
}