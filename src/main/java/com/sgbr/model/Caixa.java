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
@Table(name = "caixa")
public class Caixa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Funcionario funcionario;
	private Date data_caixa = new Date();
	private StatusCaixa status = StatusCaixa.ABERTO;
	private Date horaAbertura = new Date();
	private Date horaFechamento;
	private List<Pagamento> pagamentos = new ArrayList<>();
	private BigDecimal valorInicial = BigDecimal.ZERO;
	private BigDecimal valorTotal = BigDecimal.ZERO;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Column(name = "valor_inicial", precision = 10, scale = 2)
	public BigDecimal getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(BigDecimal valorInicial) {
		this.valorInicial = valorInicial;
	}
	
	@Column(name = "valor_total",  precision = 10, scale = 2)
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_abertura")
	public Date getHoraAbertura() {
		return horaAbertura;
	}

	public void setHoraAbertura(Date horaAbertura) {
		this.horaAbertura = horaAbertura;
	}
    
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_fechamento")
	public Date getHoraFechamento() {
		return horaFechamento;
	}

	public void setHoraFechamento(Date horaFechamento) {
		this.horaFechamento = horaFechamento;
	}
	
	@OneToMany(mappedBy = "caixa", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status",length = 20)
	public StatusCaixa getStatus() {
		return status;
	}
	

	public void setStatus(StatusCaixa status) {
		this.status = status;
	}

	@Transient
	public boolean isNovo() {
		return getId() == null;
	}

	@Transient
	public boolean isExistente() {
		return !isNovo();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Caixa other = (Caixa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

