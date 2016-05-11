package com.sgbr.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sgbr.model.Funcionario;
import com.sgbr.model.Perfil;
import com.sgbr.repository.Funcionarios;
import com.sgbr.util.cdi.CDIServiceLocator;

public class AppUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Funcionarios funcionarios = CDIServiceLocator.getBean(Funcionarios.class);
		Funcionario funcionario = funcionarios.porLogin(login);
		FuncionarioSistema user = null;

		if (funcionario != null) {
			user = new FuncionarioSistema(funcionario, getPerfis(funcionario));
		}

		return user;
	}

	private Collection<? extends GrantedAuthority> getPerfis(Funcionario funcionario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		// TODO Auto-generated method stub

     authorities.add(new SimpleGrantedAuthority(funcionario.getPerfil().getDescricao())); 

    return authorities;
	}

}
