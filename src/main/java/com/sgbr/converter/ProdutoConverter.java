package com.sgbr.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.sgbr.model.Produto;
import com.sgbr.repository.Produtos;
import com.sgbr.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter{
	
	@Inject
	private Produtos produtos;
	
	public ProdutoConverter(){
		produtos = CDIServiceLocator.getBean(Produtos.class);
	} 
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Produto retorno = null;
		
		if(value != null){
			Long id = new Long(value);
			retorno = produtos.porIdProduto(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value != null){
			return ((Produto)value).getIdProduto().toString();
		}
		return " ";
	}

	
}