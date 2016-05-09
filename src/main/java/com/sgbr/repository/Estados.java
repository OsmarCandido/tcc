package com.sgbr.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sgbr.model.Status;

public class Estados implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Status> encontrados(){
		return manager.createQuery("from Status",Status.class).getResultList();
	}
	
	public Status porId(Long id){
		return manager.find(Status.class, id);
	}
}
