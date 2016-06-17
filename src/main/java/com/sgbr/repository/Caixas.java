package com.sgbr.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.sgbr.model.Caixa;
import com.sgbr.repository.filter.CaixaFilter;
import com.sgbr.service.NegocioException;
import com.sgbr.util.jpa.Transactional;

public class Caixas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Caixa guardar(Caixa caixa) {
		return manager.merge(caixa);
	}

	@Transactional
	public void remover(Caixa caixa) {
		try {
			caixa = porIdCaixa(caixa.getId());
			manager.remove(caixa);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Caixa não pode ser excluída.");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Caixa> filtrados(CaixaFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Caixa.class);

		if (StringUtils.isNotBlank(filtro.getIdCaixa())) {
			criteria.add(Restrictions.eq("id", filtro.getIdCaixa()));
		}

		return criteria.list();
	}

	public Caixa porIdCaixa(Long idCaixa) {
		System.out.println(idCaixa);
		return manager.find(Caixa.class, idCaixa);
	}
	
	public List<Caixa> caixas(){
		return this.manager.createQuery("From Caixa",Caixa.class).getResultList();
	}
	

}