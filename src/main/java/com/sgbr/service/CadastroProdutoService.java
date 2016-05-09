package com.sgbr.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sgbr.model.Produto;
import com.sgbr.repository.Produtos;
import com.sgbr.util.jpa.Transactional;

public class CadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;
	@Transactional
	public Produto salvar(Produto produto) {
		//Alterado 09/05/2016 (Osmar) 
	//	Produto produtoExistente = produtos.porIdProduto(produto.getIdProduto());
		
		//if (produtoExistente != null && !produtoExistente.equals(produto)) {
			//throw new NegocioException("Existe um produto com esse Id.");
		//}
		
		return produtos.guardar(produto);
	}
}
