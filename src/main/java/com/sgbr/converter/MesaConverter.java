package com.sgbr.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.sgbr.model.Mesa;
import com.sgbr.repository.Mesas;
import com.sgbr.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Mesa.class)
public class MesaConverter implements Converter{
	
	@Inject
	private Mesas mesas;
	
	public MesaConverter(){
		this.mesas = CDIServiceLocator.getBean(Mesas.class);
	} 
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Mesa retorno = null;
		if(value != null){
			Long id = new Long(value);
			retorno = mesas.porIdMesa(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value != null){
			Mesa mesa = (Mesa) value;
			return mesa.getIdMesa() == null ? null : mesa.getIdMesa().toString();
			//return ((Funcionario)value).getIdFuncionario().toString();		
		}
		return " ";
	}
}