package com.sgbr.security;

import java.util.Collection;

import com.sgbr.model.Funcionario;

public class FuncionarioSistema extends Funcionario {

	private static final long serialVersionUID = 1L;
	
	private Funcionario funcionario;
	
	public FuncionarioSistema(Funcionario funcionario, Collection<? extends GrantedAuthority> authorities) {
		super(funcionario.getEmail(), funcionario.getSenha(), authorities);
		this.funcionario = funcionario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

}