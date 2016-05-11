package com.sgbr.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sgbr.model.Funcionario;
import com.sgbr.repository.Funcionarios;
import com.sgbr.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Funcionario.class)
public class FuncionarioConverter implements Converter{
	
	
	private Funcionarios funcionarios;
	
	public FuncionarioConverter(){
		this.funcionarios = CDIServiceLocator.getBean(Funcionarios.class);
	} 
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Funcionario retorno = null;
		
		if(value != null){
			Long id = new Long(value);
			retorno = funcionarios.porIdFuncionario(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value != null){
			System.out.println("teste");
			return ((Funcionario)value).getIdFuncionario().toString();
			
		}
		return " ";
	}

	
}