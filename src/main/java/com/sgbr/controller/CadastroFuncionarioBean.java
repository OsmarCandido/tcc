package com.sgbr.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.sgbr.model.Funcionario;


@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Funcionario funcionario;
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public CadastroFuncionarioBean() {
		funcionario = new Funcionario();
	}

	public void salvar() {
	}
	
}