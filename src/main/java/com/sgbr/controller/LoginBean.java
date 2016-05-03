package com.sgbr.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgbr.model.Funcionario;

@Named
@RequestScoped
public class LoginBean {
	@Inject

	private Funcionario funcionario;
	private String nomeFuncionario;
	private String senha;

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		if ("admin".equals(this.nomeFuncionario) && "123".equals(this.senha)) {
			this.funcionario.setNome(this.nomeFuncionario);
}else{

	FacesMessage mensagem = new FacesMessage("Usuário/senha inválidos!");mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);context.addMessage(null,mensagem);

}return null;}

public String getNomeFuncionario() {
return nomeFuncionario;
}

public void setNomeFuncionario(String nomeFuncionario) {
this.nomeFuncionario = nomeFuncionario;
}

public String getSenha() {
return senha;
 }

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

		