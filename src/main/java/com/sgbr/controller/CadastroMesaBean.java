package com.sgbr.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.sgbr.model.Mesa;

import antlr.collections.List;

@Named
@RequestScoped

public class CadastroMesaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List mesas;

public CadastroMesaBean(){
	mesas = (List) new ArrayList<Mesa>();
	mesas.add(new Mesa());
}

	public List getMesas() {
		return mesas;
	}
}