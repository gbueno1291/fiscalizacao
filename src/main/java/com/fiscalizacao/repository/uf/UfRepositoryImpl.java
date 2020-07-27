package com.fiscalizacao.repository.uf;

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

import com.fiscalizacao.models.Uf;
import com.fiscalizacao.repository.filter.UfFilter;

public class UfRepositoryImpl implements UfRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Uf> filtrar(UfFilter ufFilter, Pageable pageable) {
	    CriteriaBuilder buider = manager.getCriteriaBuilder();
	    CriteriaQuery<Uf> criteria = buider.createQuery(Uf.class);
	    Root<Uf> root  = criteria.from(Uf.class);
	    
	    Predicate[] predicates = criarRestricoes(ufFilter, buider, root );
	    criteria.where(predicates);
	    
	    TypedQuery<Uf> query = manager.createQuery(criteria);
	    adicionarRestricoesDePaginacao(query, pageable);
	    
	    return new PageImpl<>(query.getResultList(), pageable, total(ufFilter));
		
		
	}

	
	private Predicate[] criarRestricoes(UfFilter ufFilter, CriteriaBuilder buider, Root<Uf> root) {
		List<Predicate> predicates = new ArrayList<>();
		if(!StringUtils.isEmpty(ufFilter.getNome())) {
			predicates.add(buider.like(buider.lower(root.get("nome")), "%" + ufFilter.getNome().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}


	

	private void adicionarRestricoesDePaginacao(TypedQuery<Uf> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistroPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistroPorPagina);
		
	}
	
	private Long total(UfFilter ufFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(long.class);
		Root<Uf> root = criteria.from(Uf.class);
		
		Predicate[] predicates = criarRestricoes(ufFilter, builder, root);
		criteria.where(predicates);
		
	    criteria.select(builder.count(root));
	    return manager.createQuery(criteria).getSingleResult();

	}

}
