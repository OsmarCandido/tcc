package com.sgbr.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.sgbr.model.Pedido;
import com.sgbr.repository.filter.PedidoFilter;

public class Pedidos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Pedidos> filtrados(PedidoFilter filtro) {
		Session session = this.manager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(Pedidos.class) 
				// fazemos uma associação (join) com funcionario e nomeamos como "f"
				.createAlias("Funcionario", "f");
		
		if (filtro.getNumeroDe() != null) {
			// id deve ser maior ou igual (ge = greater or equals) a filtro.numeroDe
			criteria.add(Restrictions.ge("idPedido", filtro.getNumeroDe()));
		}

		if (filtro.getNumeroAte() != null) {
			// id deve ser menor ou igual (le = lower or equal) a filtro.numeroDe
			criteria.add(Restrictions.le("idPedido", filtro.getNumeroAte()));
		}

		if (filtro.getDataCriacaoDe() != null) {
			criteria.add(Restrictions.ge("dataCriacao", filtro.getDataCriacaoDe()));
		}
		
		if (filtro.getHoraCriacaoAte() != null) {
			criteria.add(Restrictions.le("dataCriacao", filtro.getDataCriacaoAte()));
		}

		if (filtro.getHoraCriacaoAte() != null) {
			criteria.add(Restrictions.ge("horaCriacao", filtro.getHoraCriacaoAte()));
		}
		
		if (filtro.getDataCriacaoDe() != null) {
			criteria.add(Restrictions.le("horaCriacao", filtro.getDataCriacaoDe()));
		}

		if (StringUtils.isNotBlank(filtro.getNomeFuncionario())) {
			// acessamos o nome do funcionario associado ao pedido pelo alias "f", criado anteriormente
			criteria.add(Restrictions.ilike("f.nome", filtro.getNomeFuncionario(), MatchMode.ANYWHERE));
		}
		
		if (filtro.getStatuses() != null && filtro.getStatuses().length > 0) {
			// adicionamos uma restrição "in", passando um array de constantes da enum StatusPedido
			criteria.add(Restrictions.in("status", filtro.getStatuses()));
		}
		
		return criteria.addOrder(Order.asc("idPedido")).list();
	}

	public Pedido porIdPedido(Long idPedido) {
		return this.manager.find(Pedido.class, idPedido);
	}
	
	public Pedido guardar(Pedido pedido) {
		return this.manager.merge(pedido);
	}

}