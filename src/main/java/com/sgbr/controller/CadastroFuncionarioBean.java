package com.sgbr.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.sgbr.model.Perfil;
import com.sgbr.model.Funcionario;
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
	private Perfil perfilPai;
	
	private List<Perfil> perfisRaizes;
	
	public CadastroFuncionarioBean() {
		funcionario = new Funcionario();
	}
	
	public void inicializar(){
		 if(FacesUtil.isNotPostback()){
		 perfisRaizes = perfis.raizes();
		 }
	}
				
	
	public void salvar() {
		System.out.println("Perfil: " + perfilPai.getDescricao());
		this.funcionario = cadastroFuncionarioService.salvar(this.funcionario);

	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public List<Perfil> getPerfisRaizes() {
		return perfisRaizes;
	}
	
	@NotNull
	public Perfil getPerfilPai() {
		return perfilPai;
	}

	public void setPerfilPai(Perfil perfilPai) {
		this.perfilPai = perfilPai;
	}

}