package com.sgbr.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgbr.model.Funcionario;
import com.sgbr.model.Perfil;
import com.sgbr.repository.Perfis;
import com.sgbr.service.CadastroFuncionarioService;
import com.sgbr.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Perfis perfis;
	
	@Inject
	private CadastroFuncionarioService cadastroFuncionarioService;
	
	private Funcionario funcionario;
	
//	private Perfil perfilPai;
	
	private List<Perfil> perfils;
	
	public CadastroFuncionarioBean() {
		funcionario = new Funcionario();
	}
	
	public void inicializar(){
		 if(FacesUtil.isNotPostback()){
		 perfils = perfis.encontrados();
		 }
	}
				
	public void salvar() {
		this.funcionario = cadastroFuncionarioService.salvar(this.funcionario);

		FacesUtil.addInfoMessage("Funcionário cadastrado com sucesso");
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
				
	}
	
	public List<Perfil> getPerfils() {
		return perfils;
	}

	public boolean isEditando(){
		return this.funcionario.getIdFuncionario() != null; 
	}

}