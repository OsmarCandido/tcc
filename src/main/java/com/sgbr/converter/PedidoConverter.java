  package com.sgbr.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sgbr.model.Pedido;
import com.sgbr.repository.Pedidos;
import com.sgbr.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Pedido.class)
public class PedidoConverter implements Converter{
	
	//@Inject
	private Pedidos pedidos;
	
	public PedidoConverter(){
		pedidos = CDIServiceLocator.getBean(Pedidos.class);
	} 
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pedido retorno = null;
		
		if(value != null){
			Long id = new Long(value);
			retorno = pedidos.porIdPedido(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value != null){
			Pedido pedido = (Pedido)value;
			return pedido.getIdPedido() == null ? null : pedido.getIdPedido().toString();
		}
		return " ";
	}

	
}