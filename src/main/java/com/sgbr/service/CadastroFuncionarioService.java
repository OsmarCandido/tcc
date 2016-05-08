package com.sgbr.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sgbr.model.Funcionario;
import com.sgbr.util.jpa.Transactional;

public class CadastroFuncionarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Funcionarios funcionarios;
	@Transactional
	public Funcionario salvar(Funcionario funcionario) {
		Funcionario funcionarioExistente = funcionarios.porIdFuncionario(funcionario.getIdFuncionario());
		
		if (funcionarioExistente != null && !funcionarioExistente.equals(funcionario)) {
			throw new NegocioException("Existe um funcionario com esse Id.");
		}
		
		return funcionarios.guardar(funcionario);
	}
}

