package com.sgbr.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sgbr.model.Status;
import com.sgbr.repository.Estados;
import com.sgbr.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Status.class)
public class StatusConverter implements Converter{
	 
	private Estados status;
	
	public  StatusConverter() {
		status = CDIServiceLocator.getBean(Estados.class);
	}
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Status retorno = null;
		
		if(value != null){
			Long id = new Long(value);
			retorno = status.porId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value != null){
			return ((Status)value).getId().toString();
		}
		return " ";
	}
}
