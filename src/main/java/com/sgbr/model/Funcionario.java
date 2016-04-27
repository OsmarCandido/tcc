package com.sgbr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private int idFuncionario;
	
	@Column(name="Nome",length=100,nullable=false)
	private String nome;
	
	@Column(name="Telefone",length=9,nullable=false)
	private String telefone;
	
	@Column(name="Cpf",length=11,nullable=false)
	private String cpf;
	
	@Column(name="Login",length=10,nullable=false)
	private String login;
	
	@Column(name="senha",length=10,nullable=false)
	private String senha;
	
	@Enumerated(EnumType.STRING)
	private Perfil perfil;
	
	
//Get	
	public int getIdFuncionario() {
		return idFuncionario;

	}
    
	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}
	
//Set
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFuncionario;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (idFuncionario != other.idFuncionario)
			return false;
		return true;
	   }
	
}
