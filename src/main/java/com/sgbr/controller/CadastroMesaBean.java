package com.sgbr.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgbr.model.Mesa;
import com.sgbr.model.StatusMesa;
import com.sgbr.service.CadastroMesaService;
import com.sgbr.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroMesaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Mesa mesa;
	
	@Inject
	private CadastroMesaService cadastroMesaService;


	public void inicializar(){
		if(FacesUtil.isNotPostback()){
				System.out.println("inicializando..."); 
		}
	}
	
	public void salvar() {
		this.mesa = cadastroMesaService.salvar(this.mesa);
		FacesUtil.addInfoMessage("Mesa cadastrada com sucesso!");
	}
	
	public CadastroMesaBean(){
		mesa = new Mesa();
}

	public Mesa getMesas() {
		return mesa;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public CadastroMesaService getCadastroMesaService() {
		return cadastroMesaService;
	}

	public void setCadastroMesaService(CadastroMesaService cadastroMesaService) {
		this.cadastroMesaService = cadastroMesaService;
	}
	
	public StatusMesa[] getStatus() {
		return StatusMesa.values();
	}
	
}