package com.sgbr.controller;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class PesquisaFuncionariosBean {

	private List<Integer> funcionariosFiltrados;

	public PesquisaFuncionariosBean() {

		funcionariosFiltrados = new ArrayList<Integer>();
		for (int i = 0; i < 50; i++) {
			funcionariosFiltrados.add(i);
		}
	}

	public List<Integer> getFuncionariosFiltrados() {
		return funcionariosFiltrados;
	}
}