package com.sgbr.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgbr.model.Funcionario;
import com.sgbr.model.Pagamento;
import com.sgbr.model.Pedido;
import com.sgbr.repository.Funcionarios;
import com.sgbr.service.CadastroPedidoService;
import com.sgbr.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Funcionarios funcionarios;
	
	@Inject
	private CadastroPedidoService cadastroPedidoService;
	
	@Inject
	private Pedido pedido;
	
	private List<Funcionario> vendedores;
	
	public CadastroPedidoBean() {
		limpar();
	}
	
	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			this.vendedores = this.funcionarios.vendedores();
		}
	}
	
	private void limpar() {
		pedido = new Pedido();
	}
	
	public void salvar() {
		this.pedido = this.cadastroPedidoService.salvar(this.pedido);
		
		FacesUtil.addInfoMessage("Pedido salvo com sucesso!");
	}
	
	public Pagamento[] getPagamento() {
		return Pagamento.values();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public List<Funcionario> getVendedores() {
		return vendedores;
	}
}