package com.sgbr.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgbr.model.Mesa;
import com.sgbr.model.Status;
import com.sgbr.repository.Estados;
import com.sgbr.service.CadastroMesaService;
import com.sgbr.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroMesaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Mesa mesa;
	
	@Inject
	private Estados estados;
	
	
	private List<Status> listaStatus;
	
	@Inject
	private CadastroMesaService cadastroMesaService;


	public void inicializar(){
		if(FacesUtil.isNotPostback()){
				System.out.println("inicializando...");
	
		listaStatus = estados.encontrados();  
		}
	}
	
	public void salvar() {
		this.mesa = cadastroMesaService.salvar(this.mesa);
	}
	
	public CadastroMesaBean(){
		mesa = new Mesa();
}

	public Mesa getMesas() {
		return mesa;
	}

	public List<Status> getListaStatus() {
		return listaStatus;
	}


	public Mesa getMesa() {
		return mesa;
	}


	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}


	public Estados getEstados() {
		return estados;
	}


	public void setEstados(Estados estados) {
		this.estados = estados;
	}


	public void setListaStatus(List<Status> listaStatus) {
		this.listaStatus = listaStatus;
	}


	public CadastroMesaService getCadastroMesaService() {
		return cadastroMesaService;
	}


	public void setCadastroMesaService(CadastroMesaService cadastroMesaService) {
		this.cadastroMesaService = cadastroMesaService;
	}
	
	
	
}