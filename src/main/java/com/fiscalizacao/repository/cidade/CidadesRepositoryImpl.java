package com.fiscalizacao.repository.cidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import com.fiscalizacao.models.Cidades;
import com.fiscalizacao.repository.filter.CidadeFilter;

public class CidadesRepositoryImpl implements CidadesRepositoryQuery{

	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cidades> filtrar(CidadeFilter cidadeFilter) {
	    CriteriaBuilder buider = manager.getCriteriaBuilder();
	    CriteriaQuery<Cidades> criteria = buider.createQuery(Cidades.class);
	    Root<Cidades> root  = criteria.from(Cidades.class);
	    
	    Predicate[] predicates = criarRestricoes(cidadeFilter, buider, root );
	    criteria.where(predicates);
	    
	    TypedQuery<Cidades> query = manager.createQuery(criteria);
	    return query.getResultList();
		
		
	}

	private Predicate[] criarRestricoes(CidadeFilter cidadeFilter, CriteriaBuilder buider, Root<Cidades> root) {
		List<Predicate> predicates = new ArrayList<>();
		if(!StringUtils.isEmpty(cidadeFilter.getNome())) {
			predicates.add(buider.like(buider.lower(root.get("nome")), "%" + cidadeFilter.getNome().toLowerCase() + "%"));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	
}
