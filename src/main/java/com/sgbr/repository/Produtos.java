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

import com.sgbr.model.Produto;
import com.sgbr.repository.filter.ProdutoFilter;
import com.sgbr.service.NegocioException;
import com.sgbr.util.jpa.Transactional;

public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Produto guardar(Produto produto) {
		return manager.merge(produto);
	}
	
	@Transactional
	public void remover(Produto produto) {
		try {
			produto = porIdProduto(produto.getIdProduto());
			manager.remove(produto);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Produto não pode ser excluído.");
		}
	}

	public Produto porIdProduto(String idProduto) {
		try {
			return manager.createQuery("from Produto where upper(idProduto) = :idProduto", Produto.class)
				.setParameter("idProduto", idProduto.toUpperCase())
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> filtrados(ProdutoFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Produto.class);
		
		if (StringUtils.isNotBlank(filtro.getIdProduto())) {
			criteria.add(Restrictions.eq("idProduto", filtro.getIdProduto()));
		}
		
		if (StringUtils.isNotBlank(filtro.getDescricao())) {
			criteria.add(Restrictions.ilike("descricao", filtro.getDescricao(), MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("descricao")).list();
	}

	public Produto porIdProduto(Long idProduto) {
		return manager.find(Produto.class, idProduto);
	}

	public List<Produto> porNome(String nome) {
		return this.manager.createQuery("from Produto where upper(descricao) like :descricao", Produto.class)
				.setParameter("descricao", nome.toUpperCase() + "%").getResultList();
	}
	
}