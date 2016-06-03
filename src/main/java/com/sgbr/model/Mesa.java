package com.sgbr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "mesa")
public class Mesa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idMesa;
	private String nome;
	private StatusMesa status;
    
	public void setIdMesa(Long idMesa) {
		this.idMesa = idMesa;
	}
	
	@Id
	@GeneratedValue
	public Long getIdMesa() {
		return idMesa;
	}
	
	/* Gets*/   
	
	@Column(name="nome",length=15,nullable=false)
	public String getNome() {
		return nome;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "status",nullable = false, length = 20)
	public StatusMesa getStatus() {
		return status;
	}
	
	/*Set*/
		

	public void setStatus(StatusMesa status) {
		this.status = status;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMesa == null) ? 0 : idMesa.hashCode());
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
		if (idMesa == null) {
			if (other.idMesa != null)
				return false;
		} else if (!idMesa.equals(other.idMesa))
			return false;
		return true;
	}
	
	}
