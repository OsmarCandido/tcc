package com.sgbr.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sgbr.model.Funcionario;
import com.sgbr.repository.Funcionarios;
import com.sgbr.util.jpa.Transactional;

public class CadastroFuncionarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Funcionarios funcionarios;
	@Transactional
	public Funcionario salvar(Funcionario funcionario) {
		
		//Alterado 09/05/2016 (Osmar)
		//Alterado 22/05/2016 (Ricardo)
		
		Funcionario funcionarioExistente = funcionarios.porCpf(funcionario.getCpf());
		
		if (funcionarioExistente != null && !funcionarioExistente.equals(funcionario)) {
			throw new NegocioException("Já existe um funcionario cadastrado com esse cpf.");
		}
		
		return funcionarios.guardar(funcionario);
	}
}

