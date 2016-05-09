package com.sgbr.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sgbr.model.Perfil;

public class Perfis implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public Perfil porId(Long id) {
		return manager.find(Perfil.class, id);
	}
	
	public List<Perfil> encontrados() {
		return manager.createQuery("from Perfil", 
				Perfil.class).getResultList();
	}
	
}