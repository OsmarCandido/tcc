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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "caixa")
public class Caixa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Funcionario funcionario;
	private Date data_caixa;
	private Date hora_abertura;
	private Date hora_fechamento;
	private List<Pagamento> pagamentos = new ArrayList<>();
	private BigDecimal valor_caixa = BigDecimal.ZERO;

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


	@Column(name = "valor_caixa",  precision = 10, scale = 2)
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

	@Temporal(TemporalType.DATE)
	@Column(name = "hora_abertura")
	public Date getHora_abertura() {
		return hora_abertura;
	}


	public void setHora_abertura(Date hora_abertura) {
		this.hora_abertura = hora_abertura;
	}
    
	@Temporal(TemporalType.DATE)
	@Column(name = "hora_fechamento")
	public Date getHora_fechamento() {
		return hora_fechamento;
	}


	public void setHora_fechamento(Date hora_fechamento) {
		this.hora_fechamento = hora_fechamento;
	}
	
	
	@OneToMany(mappedBy = "caixa", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}


	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
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

