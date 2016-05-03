package com.sgbr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.sgbr.service.NegocioException;

@Entity
@Table (name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idProduto;
	private String descricao;
	private Date dataValidade;
	private BigDecimal preco;
	private BigDecimal valorUnitario;
	private BigDecimal valorCusto;
	private BigDecimal valorVenda;
	private Categoria categoria;
	private Integer quantidadeEstoque;
    private Integer quantidadeMaxima;
    private Integer quantidadeMinima;
    
	
	/** Gets*/
	@Id
	@GeneratedValue
	public Long getIdProduto() {
		return idProduto;
	}

	@NotNull(message = "é obrigatório")
	@Column(name = "valor_unitario", nullable = false, precision = 10, scale = 2)
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	
	@NotNull
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "quantidade_estoque", nullable = false, length = 5)
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	
	/**enumerated  (BEBIDA, COMIDA)  */
	@Enumerated(EnumType.STRING)
	public Categoria getCategoria() {
		return categoria;
	}
	@NotNull
	@Column(precision = 10, scale = 2, nullable = false)
	public BigDecimal getPreco() {
		return preco;
	}

	@NotBlank
	@Size(max=60)
	public String getDescricao() {
		return descricao;
	}
	@Temporal(TemporalType.DATE)
	public Date getDataValidade() {
		return dataValidade;
	}
	@NotNull
	@Column(precision = 10, scale = 2, nullable = false)
	public BigDecimal getValorVenda() {
		return valorVenda;
	}
	@NotNull
	@Column(precision = 10, scale = 2, nullable = false)
	public BigDecimal getValorCusto() {
		return valorCusto;
	}
	@NotNull
	public Integer getQuantidadeMaxima() {
		return quantidadeMaxima;
	}
	@NotNull
	public Integer getQuantidadeMinima() {
		return quantidadeMinima;
	}
		
	/** Sets*/
	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
    

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public void setValorCusto(BigDecimal valorCusto) {
		this.valorCusto = valorCusto;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}
	


	public void setQuantidadeMaxima(Integer quantidadeMaxima) {
		this.quantidadeMaxima = quantidadeMaxima;
	}

	public void setQuantidadeMinima(Integer quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
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
		Produto other = (Produto) obj;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}

	public void baixarEstoque(Integer quantidade) {
		int novaQuantidade = this.getQuantidadeEstoque() - quantidade;

		if (novaQuantidade < 0) {
			throw new NegocioException("Não há disponibilidade no estoque de " + quantidade + " itens do produto "
					+ this.getIdProduto() + ".");
		}

		this.setQuantidadeEstoque(novaQuantidade);
	}

	public void adicionarEstoque(Integer quantidade) {
		this.setQuantidadeEstoque(getQuantidadeEstoque() + quantidade);
	}

}