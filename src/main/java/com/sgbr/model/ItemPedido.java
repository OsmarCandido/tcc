package com.sgbr.model;

import com.sgbr.model.Pedido;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "item_pedido")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idItem;
	private String descricao;
	private Integer quantidade = 1;
	private BigDecimal valorUnitario = BigDecimal.ZERO;
	private Pedido pedido;
	
	 
	@Id
	@GeneratedValue
	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long IdItem) {
		this.idItem = IdItem;
	}
	
	@JoinColumn(name = "descricao", nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void set(String descricao) {
		this.descricao = descricao;
	}
	
	@Column(nullable = false, length = 3)
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Column(name = "valor_unitario", nullable = false, precision = 10, scale = 2)
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	@ManyToOne
	@JoinColumn(name = "pedido_id", nullable = false)
	private Pedido idPedido;
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idItem == null) ? 0 : idItem.hashCode());
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
		ItemPedido other = (ItemPedido) obj;
		if (idItem == null) {
			if (other.idItem != null)
				return false;
		} else if (!idItem.equals(other.idItem))
			return false;
		return true;
	}

//	@Transient
//	public BigDecimal getValorTotal() {
//		return this.getValorUnitario().multiply(new BigDecimal(this.getQuantidade()));
//	}
//	
//	@Transient
//	public boolean isProdutoAssociado() {
//	return this.getDescricao() != null && this.getDescricao().getIdItem() != null;
//	}
//	
//	@Transient
//	public boolean isEstoqueSuficiente() {
//		return this.getPedido().isFechado() || this.getDescricao().getIdItem() == null 
//			|| this.getDescricao().getQuantidadeEstoque() >= this.getQuantidade(); 
//	}
//	
//	@Transient
//	public boolean isEstoqueInsuficiente() {
//		return !this.isEstoqueSuficiente();
//	}

}