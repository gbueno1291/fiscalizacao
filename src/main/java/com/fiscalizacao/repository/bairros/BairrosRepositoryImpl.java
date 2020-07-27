package com.fiscalizacao.repository.bairros;

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

import com.fiscalizacao.models.Bairros;
import com.fiscalizacao.repository.filter.BairrosFilter;

public class BairrosRepositoryImpl implements BairrosRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Bairros> filtrar(BairrosFilter bairrosFilter, Pageable pageable) {
		CriteriaBuilder buider = manager.getCriteriaBuilder();
	    CriteriaQuery<Bairros> criteria = buider.createQuery(Bairros.class);
	    Root<Bairros> root  = criteria.from(Bairros.class);
	    
	    Predicate[] predicates = criarRestricoes(bairrosFilter, buider, root );
	    criteria.where(predicates);
	    
	    TypedQuery<Bairros> query = manager.createQuery(criteria);
	    adicionarRestricoesDePaginacao(query, pageable);
	    
	    return new PageImpl<>(query.getResultList(), pageable, total(bairrosFilter));
	}
	private Predicate[] criarRestricoes(BairrosFilter bairrosFilter, CriteriaBuilder buider, Root<Bairros> root) {
		List<Predicate> predicates = new ArrayList<>();
		if(!StringUtils.isEmpty(bairrosFilter.getNome())) {
			predicates.add(buider.like(buider.lower(root.get("nome")), "%" + bairrosFilter.getNome().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Bairros> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistroPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistroPorPagina);
		
	}
	private Long total(BairrosFilter bairrosFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(long.class);
		Root<Bairros> root = criteria.from(Bairros.class);
		
		Predicate[] predicates = criarRestricoes(bairrosFilter, builder, root);
		criteria.where(predicates);
		
	    criteria.select(builder.count(root));
	    return manager.createQuery(criteria).getSingleResult();

	}

}
