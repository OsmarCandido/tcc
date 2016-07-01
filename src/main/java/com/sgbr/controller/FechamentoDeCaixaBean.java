package com.sgbr.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgbr.model.Caixa;
import com.sgbr.model.Caixa;
import com.sgbr.model.StatusCaixa;
import com.sgbr.repository.Caixas;
import com.sgbr.repository.filter.CaixaFilter;
import com.sgbr.repository.filter.CaixaFilter;

@Named
@ViewScoped
public class FechamentoDeCaixaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Caixas caixas;
	
	private CaixaFilter filtro;
	private List<Caixa> caixasFiltrados;
	
	private StatusCaixa[] status =  {StatusCaixa.FECHADO};
	
	public FechamentoDeCaixaBean() {
		filtro = new CaixaFilter();
		caixasFiltrados = new ArrayList<>();
	}
	
	public void inicializar(){
		pesquisar();
	}
	
	public void pesquisar() {
		caixasFiltrados = caixas.filtrados(filtro);
	}
	
	public StatusCaixa[] getStatuses() {
		return StatusCaixa.values();
	}
	
	public List<Caixa> getCaixasFiltrados() {
		return caixasFiltrados;
	}

	public CaixaFilter getFiltro() {
		return filtro;
	}
}
