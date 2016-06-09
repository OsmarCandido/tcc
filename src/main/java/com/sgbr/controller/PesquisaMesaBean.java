package com.sgbr.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;

import com.sgbr.model.Mesa;
import com.sgbr.repository.Mesas;
import com.sgbr.repository.filter.MesaFilter;
import com.sgbr.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaMesaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Mesas mesas;
	
	private MesaFilter filtro;
	private List<Mesa> mesasFiltrados;
	
	
	private Mesa mesaSelecionado;
	
	public PesquisaMesaBean() {
		filtro = new MesaFilter();
	}
	
	public void pesquisar() {
		mesasFiltrados = mesas.filtrados(filtro);
	}

	@PostConstruct
	public void init(){
		mesasFiltrados = mesas.filtrados(filtro);
	}
	
		
	
	public void excluir(){
		mesas.remover(mesaSelecionado);
		mesasFiltrados.remove(mesaSelecionado);
		 
		FacesUtil.addInfoMessage("Mesa: " + mesaSelecionado.getIdMesa() + " excluído com sucesso");
	}
	
	public List<Mesa> getMesasFiltrados() {
		return mesasFiltrados;
	}

	public MesaFilter getFiltro() {
		return filtro;
	}

	public Mesa getMesaSelecionado() {
		return mesaSelecionado;
	}

	public void setMesaSelecionado(Mesa mesaSelecionado) {
		this.mesaSelecionado = mesaSelecionado;
	}
	
}