package com.fiscalizacao.repository.contribuinte;

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

import com.fiscalizacao.models.Contribuinte;
import com.fiscalizacao.repository.filter.ContribuinteFilter;

public class ContribuinteRepositoryImpl implements ContribuinteRepositoryQuery{

	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Contribuinte> fitrar(ContribuinteFilter contribuinteFilter, Pageable pageable) {
	    CriteriaBuilder buider = manager.getCriteriaBuilder();
	    CriteriaQuery<Contribuinte> criteria = buider.createQuery(Contribuinte.class);
	    Root<Contribuinte> root  = criteria.from(Contribuinte.class);
	    
	    Predicate[] predicates = criarRestricoes(contribuinteFilter, buider, root );
	    criteria.where(predicates);
	    
	    TypedQuery<Contribuinte> query = manager.createQuery(criteria);
	    adicionarRestricoesDePaginacao(query, pageable);
	    return new PageImpl<>(query.getResultList(), pageable, total(contribuinteFilter));
		
		
	}

	private Predicate[] criarRestricoes(ContribuinteFilter contribuinteFilter, CriteriaBuilder buider, Root<Contribuinte> root) {
		List<Predicate> predicates = new ArrayList<>();
		if(!StringUtils.isEmpty(contribuinteFilter.getNome())) {
			predicates.add(buider.like(buider.lower(root.get("nome")), "%" + contribuinteFilter.getNome().toLowerCase() + "%"));
		}
		if(!StringUtils.isEmpty(contribuinteFilter.getCpf())) {
			predicates.add(buider.equal(buider.lower(root.get("cpf")), contribuinteFilter.getCpf()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarRestricoesDePaginacao(TypedQuery<Contribuinte> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistroPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistroPorPagina;
        
        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistroPorPagina);
	}
	private Long total(ContribuinteFilter contribuinteFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(long.class);
		Root<Contribuinte> root = criteria.from(Contribuinte.class);
		
		Predicate[] predicates = criarRestricoes(contribuinteFilter, builder, root);
		criteria.where(predicates);
		
	    criteria.select(builder.count(root));
	    return manager.createQuery(criteria).getSingleResult();
	}
	
	
}
