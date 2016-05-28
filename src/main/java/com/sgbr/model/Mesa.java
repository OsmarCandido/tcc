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
@Table(name = "mesa")
public class Mesa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idMesa;
	private String nome;
	private Status status;
    
	public void setIdMesa(Long idMesa) {
		this.idMesa = idMesa;
	}
	
	@Id
	@GeneratedValue
	public Long getIdMesa() {
		return idMesa;
	}
	
	
	
	
	/* Gets*/
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="status_id",nullable = false)
	public Status getStatus() {
		return status;
	}    
	
	@Column(name="nome",length=15,nullable=false)
	public String getNome() {
		return nome;
	}

	
	
	/*Set*/
	
	public void setNome(String nome) {
		this.nome = nome;
	}
    
	public void setStatus(Status status) {
		this.status = status;
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
