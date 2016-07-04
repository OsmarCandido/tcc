package com.sgbr.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.sgbr.model.Caixa;
import com.sgbr.repository.Caixas;
import com.sgbr.util.jpa.Transactional;

public class CadastroCaixaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Caixas caixas;
	
	@Transactional
	public Caixa salvar(Caixa caixa) {
		
		if(caixa.isNovo()){
			caixa.setHoraAbertura(new Date());
		}

		return caixas.guardar(caixa);
	}
}
