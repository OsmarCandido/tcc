package com.sgbr.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgbr.model.Pedido;
import com.sgbr.model.StatusPedido;
import com.sgbr.repository.Pedidos;
import com.sgbr.repository.filter.PedidoFilter;

@Named
@ViewScoped
public class ControleCaixaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pedidos pedidos;
	
	private PedidoFilter filtro;
	private List<Pedido> pedidosFiltrados;
	
	private StatusPedido[] status= {StatusPedido.FECHADO};
	
	public ControleCaixaBean() {
		filtro = new PedidoFilter();
		filtro.setStatuses(status);
		pedidosFiltrados = new ArrayList<>();
	}
	
	public void inicializar(){
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
}
