package com.sgbr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Table
public class Caixa implements Serializable {

	private static final long serialVersionUID = 1L;


	private Long id_funcionario;
	private Long id_caixa;
	private BigDecimal valor_caixa = BigDecimal.ZERO;
	private Date data_caixa;
	private Date hora_abertura;
	private Date hora_fechamento;
	private List<Pedido> pedidosFaturados = new ArrayList<>();
	

	@Id
	@GeneratedValue
	public Long getId_funcionario() {
		return id_funcionario;
	}


	public void setId_funcionario(Long id_funcionario) {
		this.id_funcionario = id_funcionario;
	}


	@Id
	@GeneratedValue
	public Long getId_caixa() {
		return id_caixa;
	}


	public void setId_caixa(Long id_caixa) {
		this.id_caixa = id_caixa;
	}

	@Column(name = "valor_caixa", nullable = false, precision = 10, scale = 2)
	public BigDecimal getValor_caixa() {
		return valor_caixa;
	}


	public void setValor_caixa(BigDecimal valor_caixa) {
		this.valor_caixa = valor_caixa;
	}

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data_caixa", nullable = false)
	public Date getData_caixa() {
		return data_caixa;
	}


	public void setData_caixa(Date data_caixa) {
		this.data_caixa = data_caixa;
	}

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "hora_abertura", nullable = false)
	public Date getHora_abertura() {
		return hora_abertura;
	}


	public void setHora_abertura(Date hora_abertura) {
		this.hora_abertura = hora_abertura;
	}


	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "hora_fechamento", nullable = false)
	public Date getHora_fechamento() {
		return hora_fechamento;
	}


	public void setHora_fechamento(Date hora_fechamento) {
		this.hora_fechamento = hora_fechamento;
	}


	public Pagamento getPagamento() {
		return pagamento;
	}


	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Pagamento pagamento;

	@OneToMany(mappedBy = "caixa", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Pedido> getPedidosFaturados() {
		return pedidosFaturados;
	}


	public void setPedidosFaturados(List<Pedido> pedidosFaturados) {
		this.pedidosFaturados = pedidosFaturados;
	}
	
	
	
}

