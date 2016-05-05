package com.sgbr.model;

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
	
	@Id
	@GeneratedValue
	@Column(name="IdItem", nullable=false)
	private Long idItem;
	
	@Column(nullable = false, length = 3)
	private Integer quantidade = 1;
	
	@Column(name = "valor_unitario", nullable = false, precision = 10, scale = 2)
	private BigDecimal valorUnitario = BigDecimal.ZERO;
	
	@ManyToOne
	@JoinColumn(name = "pedido_id", nullable = false)
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false)	
	private Produto produto;
	

	/**Gets */
	
	
	public Long getIdItem() {
		return idItem;
	}
		
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public Pedido getPedido() {
		return pedido;
	}
	
	public Produto getProduto() {
		return produto;
	}

	
	/**Sets */ 

	public void setIdItem(Long IdItem) {
		this.idItem = IdItem;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
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

	@Transient
	public BigDecimal getValorTotal() {
		return this.getValorUnitario().multiply(new BigDecimal(this.getQuantidade()));
	}
	
	@Transient
	public boolean isProdutoAssociado() {
		return this.getProduto() != null && this.getProduto().getIdProduto() != null;
	}
	
	
	@Transient
	public boolean isEstoqueSuficiente(){//Estoque suficiente
		return this.pedido.isAberto() || this.getProduto().getIdProduto() == null
				|| this.getProduto().getQuantidadeEstoque() >= this.getQuantidade(); 
	}
	
	@Transient
	public boolean isEstoqueInsuficiente(){//verifico a negativa do estoque suficiete, se não for suficiente então...
		return !isEstoqueSuficiente();
	}
}