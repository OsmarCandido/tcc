package com.sgbr.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.sgbr.model.Caixa;
import com.sgbr.repository.Caixas;
import com.sgbr.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Caixa.class)
public class CaixaConverter implements Converter{
	
	@Inject
	private Caixas caixas;
	
	public CaixaConverter(){
		this.caixas = CDIServiceLocator.getBean(Caixas.class);
	} 
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Caixa retorno = null;
		Caixa res;
		if(value != null){
			Long id = new Long(value);
			System.out.println("getAsObj = " + id);
			res = caixas.porIdCaixa(id);
			System.out.println("getAsObj2 = " + res.getFuncionario().getNome());
			retorno = caixas.porIdCaixa(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value != null){
			Caixa caixa = (Caixa) value;
			System.out.println("getAsString = " + caixa.getId().toString());
			return caixa.getId() == null ? null : caixa.getId().toString();		
		}
		return " ";
	}
}