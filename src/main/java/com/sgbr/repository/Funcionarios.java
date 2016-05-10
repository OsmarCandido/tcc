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

import com.sgbr.model.Funcionario;
import com.sgbr.repository.filter.FuncionarioFilter;
import com.sgbr.service.NegocioException;
import com.sgbr.util.jpa.Transactional;

public class Funcionarios implements Serializable {
  
	private static final long serialVersionUID = 1L;
		
	@Inject
	private EntityManager manager;

	public Funcionario guardar(Funcionario funcionario) {
		return manager.merge(funcionario);
	}

	@Transactional
	public void remover(Funcionario funcionario) {
		try {
			funcionario = porIdFuncionario(funcionario.getIdFuncionario());
			manager.remove(funcionario);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Funcionario não pode ser excluído.");
		}
	}

	public Funcionario porIdFuncionario(String idFuncionario) {
		try {
			return manager
					.createQuery("from Funcionario where upper(idFuncionario) = :idFuncionario", Funcionario.class)
					.setParameter("idFuncionario", idFuncionario.toUpperCase()).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> filtrados(FuncionarioFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Funcionario.class);

		if (StringUtils.isNotBlank(filtro.getIdFuncionario())) {
			criteria.add(Restrictions.eq("idFuncionario", filtro.getIdFuncionario()));
		}

		if (StringUtils.isNotBlank(filtro.getDescricao())) {
			criteria.add(Restrictions.ilike("descricao", filtro.getDescricao(), MatchMode.ANYWHERE));
		}

		return criteria.addOrder(Order.asc("descricao")).list();
	}

	public Funcionario porIdFuncionario(Long idFuncionario) {
		return manager.find(Funcionario.class, idFuncionario);
	}

	public List<Funcionario> porNome(String nome) {
		return this.manager.createQuery("from Funcionario" + "where upper(nome) like :nome", Funcionario.class)
				.setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}
	
	public List<Funcionario> vendedores(){
		//TODO filtrar apenas vendedores por um grupo específico
		return this.manager.createQuery("From Funcionario",Funcionario.class).getResultList();
	}	
	
}


