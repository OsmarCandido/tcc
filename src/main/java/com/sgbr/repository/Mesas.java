package com.sgbr.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.sgbr.model.Mesa;
import com.sgbr.model.Produto;
import com.sgbr.repository.filter.MesaFilter;
import com.sgbr.service.NegocioException;
import com.sgbr.util.jpa.Transactional;

public class Mesas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Mesa guardar(Mesa mesa) {
		return manager.merge(mesa);
	}

	@Transactional
	public void remover(Mesa mesa) {
		try {
			mesa = porIdMesa(mesa.getIdMesa());
			manager.remove(mesa);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Mesa não pode ser excluída.");
		}
	}

	public Mesa porIdMesa(String idMesa) {
		try {
			return manager.createQuery("from Mesa where upper(idMesa) = :idMesa", Mesa.class)
					.setParameter("idMesa", idMesa.toUpperCase()).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Mesa> filtrados(MesaFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Mesa.class);

		if (StringUtils.isNotBlank(filtro.getIdMesa())) {
			criteria.add(Restrictions.eq("idMesa", filtro.getIdMesa()));
		}

		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}

		return criteria.addOrder(Order.asc("status")).list();
	}

	public Mesa porIdMesa(Long idMesa) {
		return manager.find(Mesa.class, idMesa);
	}

	public List<Produto> porNome(String nome) {
		return this.manager.createQuery("from Produto where upper(descricao) like :descricao", Produto.class)
				.setParameter("descricao", nome.toUpperCase() + "%").getResultList();
	}

}