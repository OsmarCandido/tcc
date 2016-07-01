package com.sgbr.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgbr.model.Caixa;
import com.sgbr.model.Pedido;
import com.sgbr.model.StatusPedido;
import com.sgbr.repository.Caixas;
import com.sgbr.repository.Pedidos;
import com.sgbr.repository.filter.CaixaFilter;
import com.sgbr.repository.filter.PedidoFilter;

@Named
@ViewScoped
public class RelatorioDeCaixaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pedidos pedidos;
	
	@Inject
	private Caixas caixas;
	
	private long numCaixa;
	
	@Inject
	private Caixa caixa;
	
	private PedidoFilter filtro;
	private CaixaFilter filtroCaixa;
	
	private List<Pedido> pedidosFiltrados;
	private List<Caixa> caixasFiltrados;
	
	private StatusPedido[] status= {StatusPedido.FECHADO};
	
	public RelatorioDeCaixaBean() {
		filtro = new PedidoFilter();
	//	filtro.setStatuses(status);
		filtro.setNumCaixa(numCaixa);
		pedidosFiltrados = new ArrayList<>();

	}
	
	public void inicializar(){
		System.out.println("inicializar" + caixa.getId());
		numCaixa = caixa.getId();
		pesquisar();
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
	
	
}
