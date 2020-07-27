package com.fiscalizacao.repository.logradouros;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.fiscalizacao.models.Logradouros;
import com.fiscalizacao.repository.filter.LogradourosFilter;

public class LogradourosRepositoryImpl implements LogradourosRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Logradouros> filtrar(LogradourosFilter logradourosFilter, Pageable pageable) {
		 CriteriaBuilder buider = manager.getCriteriaBuilder();
		    CriteriaQuery<Logradouros> criteria = buider.createQuery(Logradouros.class);
		    Root<Logradouros> root  = criteria.from(Logradouros.class);
		    
		    Predicate[] predicates = criarRestricoes(logradourosFilter, buider, root );
		    criteria.where(predicates);
		    
		    TypedQuery<Logradouros> query = manager.createQuery(criteria);
		    adicionarRestricoesDePaginacao(query, pageable);
		    
		    return new PageImpl<>(query.getResultList(), pageable, total(logradourosFilter));
	}

	private Predicate[] criarRestricoes(LogradourosFilter logradourosFilter, CriteriaBuilder buider, Root<Logradouros> root) {
		List<Predicate> predicates = new ArrayList<>();
		if(!StringUtils.isEmpty(logradourosFilter.getNome())) {
			predicates.add(buider.like(buider.lower(root.get("nome")), "%" + logradourosFilter.getNome().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarRestricoesDePaginacao(TypedQuery<Logradouros> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistroPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistroPorPagina);
		
	}
	
	private Long total(LogradourosFilter logradourosFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(long.class);
		Root<Logradouros> root = criteria.from(Logradouros.class);
		
		Predicate[] predicates = criarRestricoes(logradourosFilter, builder, root);
		criteria.where(predicates);
		
	    criteria.select(builder.count(root));
	    return manager.createQuery(criteria).getSingleResult();
	}
	
	
	

}
