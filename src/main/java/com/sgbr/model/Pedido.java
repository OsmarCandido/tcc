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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idPedido;
	private Date dataCriacao;
	private String observacao;
	private BigDecimal subTotal;
	private BigDecimal valorTotal;
	private StatusOld status;
	private Pagamento pagamento;
	private Funcionario funcionario;
	private List<ItemPedido> itens = new ArrayList<>();

	@Id
	@GeneratedValue
	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao", nullable = false)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Column(columnDefinition = "text")
	public String getObservacao() {
		return observacao;
	}

	@NotNull
	@Column(name = "subtotal", nullable = false, precision = 10, scale = 2)
	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@NotNull
	@Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	public StatusOld getStatus() {
		return status;
	}

	public void setStatus(StatusOld status) {
		this.status = status;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "pagamento", nullable = false, length = 20)
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "funcionario", nullable = false)
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
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

@Transient
public boolean isNovo() {
	return getIdPedido() == null;
}

@Transient
public boolean isExistente() {
	return !isNovo();
}

@Transient
public boolean isValorTotalNegativo() {
	return this.getValorTotal().compareTo(BigDecimal.ZERO) < 0;
}

@Transient
public boolean isEmitido() {
	return StatusOld.ABERTO.equals(this.getStatus());
}

@Transient
public boolean isCancelavel() {
	return this.isExistente() && !this.isCancelado();
}

@Transient
private boolean isCancelado() {
	return StatusOld.CANCELADO.equals(this.getStatus());
}

@Transient
public boolean isNaoCancelavel() {
	return !this.isCancelavel();
}

}

