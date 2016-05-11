package com.sgbr.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Named
@SessionScoped
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private HttpServletRequest request;
	
	@Inject 
	private HttpServletResponse response;
		
	
	//private Funcionario funcionario;
	private String nomeFuncionario;
	//private String senha;


	
	public void login() throws ServletException, IOException{
	 RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
	 dispatcher.forward(request, response);
	 
	 facesContext.responseComplete();
	 
	}
	
	//Gets e Sets
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

//	public String getSenha() {
	//	return senha;
	//}

	//public void setSenha(String senha) {
		//this.senha = senha;
//	}
}
