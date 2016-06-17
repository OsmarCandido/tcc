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

import com.sgbr.model.Pagamento;
import com.sgbr.model.Produto;
import com.sgbr.repository.filter.PagamentoFilter;
import com.sgbr.service.NegocioException;
import com.sgbr.util.jpa.Transactional;

public class Pagamentos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Pagamento guardar(Pagamento pagamento) {
		return manager.merge(pagamento);
	}

	@Transactional
	public void remover(Pagamento pagamento) {
		try {
			pagamento = porIdPagamento(pagamento.getId());
			manager.remove(pagamento);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Pagamento não pode ser excluída.");
		}
	}

	public Pagamento porIdPagamento(String idPagamento) {
		try {
			return manager.createQuery("from Pagamento where upper(idPagamento) = :idPagamento", Pagamento.class)
					.setParameter("idPagamento", idPagamento.toUpperCase()).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Pagamento> filtrados(PagamentoFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Pagamento.class);

		if (StringUtils.isNotBlank(filtro.getIdPagamento())) {
			criteria.add(Restrictions.eq("idPagamento", filtro.getIdPagamento()));
		}

		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}

		return criteria.addOrder(Order.asc("status")).list();
	}

	public Pagamento porIdPagamento(Long idPagamento) {
		return manager.find(Pagamento.class, idPagamento);
	}

	public List<Produto> porNome(String nome) {
		return this.manager.createQuery("from Pagamento where upper(descricao) like :descricao", Produto.class)
				.setParameter("pedido", nome.toUpperCase() + "%").getResultList();
	}
	
	public List<Pagamento> pagamentos(){
		return this.manager.createQuery("From Pagamento",Pagamento.class).getResultList();
	}
	

}