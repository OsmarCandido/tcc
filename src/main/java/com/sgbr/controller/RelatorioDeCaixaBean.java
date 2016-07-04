package com.sgbr.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Transient;

import com.sgbr.model.Caixa;
import com.sgbr.model.Pedido;
import com.sgbr.model.StatusCaixa;
import com.sgbr.model.StatusPedido;
import com.sgbr.repository.Caixas;
import com.sgbr.repository.Pedidos;
import com.sgbr.repository.filter.CaixaFilter;
import com.sgbr.repository.filter.PedidoFilter;
import com.sgbr.service.CadastroCaixaService;
import com.sgbr.util.jsf.FacesUtil;

@Named
@ViewScoped
public class RelatorioDeCaixaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pedidos pedidos;
	
	@Inject
	private Caixas caixas;
	
	@Inject
	private Caixa caixa;
	
	private PedidoFilter filtro;
	private CaixaFilter filtroCaixa;
	
	private List<Pedido> pedidosFiltrados;
	private List<Caixa> caixasFiltrados;
	
	@Inject
	private CadastroCaixaService cadastroCaixaService;
	
	public RelatorioDeCaixaBean() {
		filtro = new PedidoFilter();
	}
	
	public void inicializar(){
	}
	
	public void pesquisar() {
		pedidosFiltrados = pedidos.filtrados(filtro);
	}
	
	public StatusPedido[] getStatuses() {
		return StatusPedido.values();
	}
	
	public List<Pedido> getPedidosFiltrados() {
		return pedidosFiltrados;
	}

	public PedidoFilter getFiltro() {
		return filtro;
	}

	public Caixas getCaixas() {
		return caixas;
	}

	public void setCaixas(Caixas caixas) {
		this.caixas = caixas;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public CaixaFilter getFiltroCaixa() {
		return filtroCaixa;
	}

	public List<Caixa> getCaixasFiltrados() {
		return caixasFiltrados;
	}
	
	public boolean isEditando() {
		return this.caixa.getId() != null;
	}
	
	public void salvar() {
		try {
			this.caixa = this.cadastroCaixaService.salvar(this.caixa);
			FacesUtil.addInfoMessage("Fechamento realizado com sucesso!");
		} finally {
		}
	}
	
	public void fecharCaixa() {
		this.caixa.setHoraFechamento(new Date());
		this.caixa.setStatus(StatusCaixa.FECHADO);
		this.caixa.setValorTotal(caixa.calcularTotal());
		this.salvar();
	}
	
}
