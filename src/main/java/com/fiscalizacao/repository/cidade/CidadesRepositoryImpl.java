package com.fiscalizacao.repository.cidade;

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

import com.fiscalizacao.models.Cidades;
import com.fiscalizacao.repository.filter.CidadeFilter;

public class CidadesRepositoryImpl implements CidadesRepositoryQuery{

	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Cidades> filtrar(CidadeFilter cidadeFilter, Pageable pageable) {
	    CriteriaBuilder buider = manager.getCriteriaBuilder();
	    CriteriaQuery<Cidades> criteria = buider.createQuery(Cidades.class);
	    Root<Cidades> root  = criteria.from(Cidades.class);
	    
	    Predicate[] predicates = criarRestricoes(cidadeFilter, buider, root );
	    criteria.where(predicates);
	    
	    TypedQuery<Cidades> query = manager.createQuery(criteria);
	    adicionarRestricoesDePaginacao(query, pageable);
	    
	    return new PageImpl<>(query.getResultList(), pageable, total(cidadeFilter));
		
		
	}

	
	private Predicate[] criarRestricoes(CidadeFilter cidadeFilter, CriteriaBuilder buider, Root<Cidades> root) {
		List<Predicate> predicates = new ArrayList<>();
		if(!StringUtils.isEmpty(cidadeFilter.getNome())) {
			predicates.add(buider.like(buider.lower(root.get("nome")), "%" + cidadeFilter.getNome().toLowerCase() + "%"));
		}
		
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}


	

	private void adicionarRestricoesDePaginacao(TypedQuery<Cidades> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistroPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistroPorPagina);
		
	}
	
	private Long total(CidadeFilter cidadeFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(long.class);
		Root<Cidades> root = criteria.from(Cidades.class);
		
		Predicate[] predicates = criarRestricoes(cidadeFilter, builder, root);
		criteria.where(predicates);
		
	    criteria.select(builder.count(root));
	    return manager.createQuery(criteria).getSingleResult();

	}



}
