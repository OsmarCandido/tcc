package com.sgbr.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.sgbr.util.report.ExecutorRelatorio;


@Named
@ViewScoped
public class RelatorioGraficoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext facesContext;

	@Inject
	private HttpServletResponse response;

	@Inject
	private EntityManager manager;

	public void emitir(){
		
		Map<String, Object> parametros = new HashMap<>();

		ExecutorRelatorio executor = new ExecutorRelatorio("/relatorios/Relatoriografico.jasper",
				this.response, parametros, "Grafico.pdf");
		

		Session session = manager.unwrap(Session.class);
		session.doWork(executor);

		facesContext.responseComplete();
	}
	
}
