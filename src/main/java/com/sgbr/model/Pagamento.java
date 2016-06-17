package com.sgbr.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable {

	private static final long serialVersionUID = 1L; 

	private long id;
	private Pedido pedido;
	private FormaPagamento forma;
	private BigDecimal valor;
	private Caixa caixa;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	
	
	public void setId(long id) {
		this.id = id;
	}
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "pedido", nullable = false)
	public Pedido getPedido() {
		return pedido;
	}
	
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "forma_pagamento", nullable = false, length = 20)
	public FormaPagamento getForma() {
		return forma;
	}
	
	public void setForma(FormaPagamento forma) {
		this.forma = forma;
	}
	
	@NotNull
	@Column(name = "valor", nullable = false, precision = 10, scale = 2)
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "caixa_id", nullable = false)
	public Caixa getCaixa() {
		return caixa;
	}


	public void setCaixa(Caixa caixa) {
		System.out.println("caixa: id =" + caixa.getId());
		this.caixa = caixa;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Pagamento other = (Pagamento) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
