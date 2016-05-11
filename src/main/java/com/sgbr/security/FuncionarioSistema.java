package com.sgbr.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import com.sgbr.model.Funcionario;


public class FuncionarioSistema extends User{

	private static final long serialVersionUID=1L;
	
	private Funcionario funcionario;
	
	public FuncionarioSistema(Funcionario funcionario, Collection<? extends GrantedAuthority> authorities) {
		super(funcionario.getLogin(), funcionario.getSenha(), authorities);
		this.funcionario = funcionario;
		// TODO Auto-generated constructor stub	
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
}
