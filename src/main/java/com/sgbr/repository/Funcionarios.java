package com.sgbr.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sgbr.model.Funcionario;

public class Funcionarios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Funcionario porId(Long id) {
		return this.manager.find(Funcionario.class, id);
	}

	public List<Funcionario> porNome(String nome) {
		return this.manager
				.createQuery("from Funcionario where upper(nome) like :nome",
						Funcionario.class)
				.setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}
}