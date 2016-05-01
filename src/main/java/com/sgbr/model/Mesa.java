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
public class Mesa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int idMesa;
	
	
	@Column(name="Nome",length=6,nullable=false)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status;
    
	/* Gets*/
	
	public Status getStatus() {
		return status;
	}    
	public String getNome() {
		return nome;
	}


	public int getIdMesa() {
		return idMesa;
	}
	
	/*Set*/
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
    
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMesa;
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
		Mesa other = (Mesa) obj;
		if (idMesa != other.idMesa)
			return false;
		return true;
	}

	
	
	
	}
