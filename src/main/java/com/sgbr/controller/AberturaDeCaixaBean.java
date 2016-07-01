package com.sgbr.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgbr.model.Caixa;
import com.sgbr.model.Funcionario;
import com.sgbr.model.StatusCaixa;
import com.sgbr.repository.Funcionarios;
import com.sgbr.service.AberturaDeCaixaService;
import com.sgbr.service.CadastroCaixaService;
import com.sgbr.util.jsf.FacesUtil;

@Named
@ViewScoped
public class AberturaDeCaixaBean implements Serializable {

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

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			caixa = new Caixa();
			operadores = funcionarios.vendedores();
		}

	}

	public void salvar() {
		try {
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

	public void fecharCaixa() {
		this.caixa.setHoraFechamento(new Date());
		this.caixa.setStatus(StatusCaixa.FECHADO);
		this.caixa.setValorTotal(caixa.calcularTotal());
		this.salvar();
	}
}
