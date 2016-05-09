package com.sgbr.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sgbr.model.Mesa;
import com.sgbr.repository.Mesas;
import com.sgbr.util.jpa.Transactional;

public class CadastroMesaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Mesas mesas;
	@Transactional
	public Mesa salvar(Mesa mesa) {
		Mesa mesaExistente = mesas.porIdMesa(mesa.getIdMesa());
		
		if (mesaExistente != null && !mesaExistente.equals(mesa)) {
			throw new NegocioException("Existe uma mesa com esse Id.");
		}
		
		return mesas.guardar(mesa);
	}
}
