package com.sgbr.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sgbr.model.Pagamento;
import com.sgbr.repository.Pagamentos;
import com.sgbr.util.jpa.Transactional;

public class RegistraPagamentoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pagamentos pagamentos;
	@Transactional
	public Pagamento salvar(Pagamento pagamento) {
		Pagamento pagamentoExistente = pagamentos.porIdPagamento(pagamento.getId());
		
		if (pagamentoExistente != null && !pagamentoExistente.equals(pagamento)) {
			throw new NegocioException("Existe uma pagamento com esse Id.");
		}
		
		return pagamentos.guardar(pagamento);
	}
}
