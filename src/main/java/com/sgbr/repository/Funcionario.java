package com.sgbr.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Funcionario porIdFuncionario(Long idFuncionario) {
		return manager.find(Funcionario.class, idFuncionario);
	}

	public List<Funcionario> funcionarios() {
		return this.manager
				.createQuery("from Funcionario ",
						Funcionario.class).getResultList();
	}

}