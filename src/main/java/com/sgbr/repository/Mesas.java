package com.sgbr.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.sgbr.model.Mesa;
import com.sgbr.model.Produto;

public class Mesas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Mesa guardar(Mesa mesa) {
		return manager.merge(mesa);
	}
	
/*	@Transactional
	public void remover(Mesa mesa) {
		try {
			mesa = porIdProduto(produto.getIdProduto());
			manager.remove(produto);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Produto não pode ser excluído.");
		}
	}*/

	public Mesa porIdMesa(String idMesa) {
		try {
			return manager.createQuery("from Mesa where upper(idMesa) = :idMesa", Mesa.class)
				.setParameter("idMesa", idMesa.toUpperCase())
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	/*
	@SuppressWarnings("unchecked")
	public List<Produto> filtrados(ProdutoFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Mesa.class);
		
		if (StringUtils.isNotBlank(filtro.getIdProduto())) {
			criteria.add(Restrictions.eq("idMesa", filtro.getIdProduto()));
		}
		
		if (StringUtils.isNotBlank(filtro.getDescricao())) {
			criteria.add(Restrictions.ilike("descricao", filtro.getDescricao(), MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("descricao")).list();
	}*/

	public Mesa porIdMesa(Long idMesa) {
		return manager.find(Mesa.class, idMesa);
	}

	public List<Produto> porNome(String nome) {
		return this.manager.createQuery("from Produto where upper(descricao) like :descricao", Produto.class)
				.setParameter("descricao", nome.toUpperCase() + "%").getResultList();
	}
	
}