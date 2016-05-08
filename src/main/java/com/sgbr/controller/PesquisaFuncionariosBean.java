package com.sgbr.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgbr.model.Funcionario;
import com.sgbr.repository.Funcionarios;
import com.sgbr.repository.filter.FuncionarioFilter;

@Named
@ViewScoped
public class PesquisaFuncionariosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Funcionarios funcionarios;
	
	private FuncionarioFilter filtro;
	private List<Funcionario> funcionariosFiltrados;
	
	public PesquisaFuncionariosBean() {
		filtro = new FuncionarioFilter();
	}
	
	public void pesquisar() {
		funcionariosFiltrados = funcionarios.filtrados(filtro);
	}
	
	public List<Funcionario> getFuncionariosFiltrados() {
		return funcionariosFiltrados;
	}

	public FuncionarioFilter getFiltro() {
		return filtro;
	}
	
}