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
		if(value != null){
			Long id = new Long(value);
			retorno = caixas.porIdCaixa(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value != null){
			Caixa caixa = (Caixa) value;
			return caixa.getId() == null ? null : caixa.getId().toString();		
		}
		return " ";
	}
}