package com.sgbr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "funcionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idFuncionario;
	private String nome;
	private String telefone;
	private String cpf;
	private String login;
	private String senha;
	private Perfil perfil;
	
//Get
	@Id
	@GeneratedValue
	public Long getIdFuncionario() {
		return idFuncionario;

	}
    
	@Column(name="Nome",length=100,nullable=false)
	public String getNome() {
		return nome;
	}

	@Column(name="Telefone",length=14,nullable=false)
	public String getTelefone() {
		return telefone;
	}

	@Column(name="Cpf",length=14,nullable=false)
	public String getCpf() {
		return cpf;
	}

	@Column(name="Login",length=10,nullable=false)
	public String getLogin() {
		return login;
	}

	@Column(name="senha",length=10,nullable=false)
	public String getSenha() {
		return senha;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name="perfil_id", nullable=false)                                    //@Enumerated(EnumType.STRING)
	public Perfil getPerfil() {
		return perfil;
	}
	
//Set
		
	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
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
		result = prime * result + ((idFuncionario == null) ? 0 : idFuncionario.hashCode());
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
		if (idFuncionario == null) {
			if (other.idFuncionario != null)
				return false;
		} else if (!idFuncionario.equals(other.idFuncionario))
			return false;
		return true;
	}
	
}
