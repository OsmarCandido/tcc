package com.sgbr.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.sgbr.model.Perfil;
import com.sgbr.model.Funcionario;
import com.sgbr.repository.Perfil;
import com.sgbr.service.CadastroFuncionarioService;

@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Perfis perfis;
	
	@Inject
	private CadastroFuncioanrioService cadastroFuncionarioService;
	
	private Funcionario funcionario;
	private Perfil perfilPai;
	private Perfil perfil;
	
	private List<Perfil> perfisRaizes;
	
	
	public CadastroFuncionarioBean() {
		produto = new Produto();
	}
	
	public void inicializar(){
		 categoriasRaizes = categorias.raizes();
	}
		
	public void salvar() {
		this.funcionario = cadastroFuncionarioService.salvar(this.funcioanario);
		
	}

	public Produto getFuncionario() {
		return funcionario;
	}

	public List<perfil> getPerfisRaizes() {
		return perfisRaizes;
	}
	
	@NotNull
	public Perfil getPerfilPai() {
		return perfilPai;
	}

	public void setPerfilPai(Perfil perfilPai) {
		this.perfilPai = perfilPai;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
}