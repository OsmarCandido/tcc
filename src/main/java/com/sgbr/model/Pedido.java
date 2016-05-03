package com.sgbr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="idPedido", nullable=false)
	private Long idPedido;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="dataCriacao",nullable=false)
	private Date dataCriacao;
	
	@Column(name="Observacao",length=100,nullable=false)
	private String observacao;
	
	@Column(name="ValorTotal",nullable=false)
	private BigDecimal valorTotal;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Pedido", nullable=false)
	private Status status;
	
	@ManyToOne
	@JoinColumn (name="idFuncionario")
	private Funcionario funcionario;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<>();
	
	private Pagamento pagamento;
		
	/** Gets */ 
	

	public Pagamento getPagamento() {
		return pagamento;
	}


	public Long getIdPedido() {
		return idPedido;
	}


	public Date getDataCriacao() {
		return dataCriacao;
	}
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	
	/**ABERTO, FECHADO, CANCELADO*/
	@Enumerated (EnumType.STRING)
	public Status getStatus() {
		return status;
	}
	
	public String getObservacao() {
		return observacao;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	@OneToMany 
	public List<ItemPedido> getItens() {
		return itens;
	}
	
	
	/** Sets*/
	
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
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
		Pedido other = (Pedido) obj;
		if (idPedido == null) {
			if (other.idPedido != null)
				return false;
		} else if (!idPedido.equals(other.idPedido))
			return false;
		return true;
	}


	
}