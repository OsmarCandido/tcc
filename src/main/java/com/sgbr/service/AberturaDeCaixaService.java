package com.sgbr.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.sgbr.model.Caixa;
import com.sgbr.repository.Caixas;
import com.sgbr.util.jpa.Transactional;

public class AberturaDeCaixaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Caixas caixas;
	
	@Inject
	private Caixa caixa;

	@Inject
	EstoqueService estoqueService;
	
	@Inject
	RegistraPagamentoService registraPagamentoService;
	
	@Inject
	CadastroCaixaService cadastroCaixaService;

	@Transactional
	public Caixa salvar(Caixa caixa) {
		System.out.println(this.caixa.getData_caixa());
		System.out.println(this.caixa.getFuncionario().getNome());
		System.out.println(this.caixa.getHoraAbertura());
		System.out.println(this.caixa.getId());
		System.out.println(this.caixa.getValorInicial());
		System.out.println(this.caixa.getValorTotal());
		
		System.out.println("caixa iniciado");
		//caixa = this.caixas.guardar(caixa);

		return caixa;
	}

}