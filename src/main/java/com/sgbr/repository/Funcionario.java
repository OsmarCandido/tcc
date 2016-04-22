package com.sgbr.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Funcionario porIdFuncionario(Long id) {
		return this.manager.find(Funcionario.class, id);
	}
	
	public List<Funcionario> vendedores() {
		// TODO filtrar apenas vendedores (por um grupo especifico)
		return this.manager.createQuery("from Funcionario", Funcionario.class)
				.getResultList();
	}

	public Funcionario porLogin(String login) {
		Funcionario funcionario = null;
		
		try {
			funcionario = this.manager.createQuery("from Funcionario where lower(login) = :login", Funcionario.class)
				.setParameter("login", login.toLowerCase()).getSingleResult();
		} catch (NoResultException e) {
			// nenhum usu�rio encontrado com o nome informado
		}
		
		return funcionario;
	}
	
}