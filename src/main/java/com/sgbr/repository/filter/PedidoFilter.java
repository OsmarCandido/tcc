package com.sgbr.repository.filter;

import java.io.Serializable;
import java.util.Date;

import com.sgbr.model.StatusOld;

public class PedidoFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long numeroDe;
	private Long numeroAte;
	private Date dataCriacaoDe;
	private Date dataCriacaoAte;
	private Date horaCriacaoDe;
	private Date horaCriacaoAte;
	private String nomeFuncionario;
	private StatusOld[] statuses;

	public Long getNumeroDe() {
		return numeroDe;
	}

	public void setNumeroDe(Long numeroDe) {
		this.numeroDe = numeroDe;
	}

	public Long getNumeroAte() {
		return numeroAte;
	}

	public void setNumeroAte(Long numeroAte) {
		this.numeroAte = numeroAte;
	}

	public Date getDataCriacaoDe() {
		return dataCriacaoDe;
	}

	public void setDataCriacaoDe(Date dataCriacaoDe) {
		this.dataCriacaoDe = dataCriacaoDe;
	}

	public Date getDataCriacaoAte() {
		return dataCriacaoAte;
	}

	public void setDataCriacaoAte(Date dataCriacaoAte) {
		this.dataCriacaoAte = dataCriacaoAte;
	}

	public Date getHoraaCriacaoDe() {
		return horaCriacaoDe;
	}

	public void setHoraCriacaoDe(Date horaCriacaoDe) {
		this.horaCriacaoDe = horaCriacaoDe;
	}

	public Date getHoraCriacaoAte() {
		return horaCriacaoAte;
	}

	public void setHoraCriacaoAte(Date horaCriacaoAte) {
		this.horaCriacaoAte = horaCriacaoAte;
	}

	
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	
	public StatusOld[] getStatuses() {
		return statuses;
	}

	public void setStatuses(StatusOld[] statuses) {
		this.statuses = statuses;
	}

}