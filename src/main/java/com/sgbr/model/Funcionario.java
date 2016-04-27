package com.sgbr.model;

import java.io.Serializable;

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
	
	private int idFuncionario;
	private String nome;
	private String telefone;
	private String cpf;
	private String login;
	private String senha;
	private Perfil perfil;



	/**Gets*/ 
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
	
	/**enumerated  (GARCOM, GERENTE, CAIXA, CHEF)  */
	@Enumerated (EnumType.STRING)
	public Perfil getPerfil() {
		return perfil;
	}
	
	@Id
	@GeneratedValue
		public int getIdFuncionario() {
			return idFuncionario;
		}
	
	
	

	/**Sets*/

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
