package com.sgbr.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgbr.model.Caixa;
import com.sgbr.model.Funcionario;
import com.sgbr.repository.Funcionarios;
import com.sgbr.service.AberturaDeCaixaService;
import com.sgbr.service.CadastroCaixaService;
import com.sgbr.util.jsf.FacesUtil;

@Named
@ViewScoped
public class AberturaDeCaixaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Caixa caixa;
	
	private List<Funcionario> operadores;
	
	@Inject
	private Funcionarios funcionarios;
	
	private Funcionario funcionario;
	
	private AberturaDeCaixaService aberturaDeCaixaService;
	
	@Inject
	private CadastroCaixaService cadastroCaixaService;
	
	public AberturaDeCaixaBean() {
	}
	
	public void inicializar(){
		if (FacesUtil.isNotPostback()) {
		caixa = new Caixa();
		operadores = funcionarios.vendedores();
		}
		
	}
	
	public void salvar() {
		try {
			System.out.println(this.caixa.getData_caixa());
			System.out.println(this.caixa.getFuncionario().getNome());
			System.out.println(this.caixa.getHoraAbertura());
			System.out.println(this.caixa.getId());
			System.out.println(this.caixa.getValorInicial());
			System.out.println(this.caixa.getValorTotal());
			this.caixa = this.cadastroCaixaService.salvar(this.caixa);
			FacesUtil.addInfoMessage("Caixa iniciado com sucesso!");
		} finally {
		}

	}
	
	public List<Funcionario> getOperadores() {
		return operadores;
	}

	public Caixa getCaixa() {
		return caixa;
	}
	
	
	
	
}
