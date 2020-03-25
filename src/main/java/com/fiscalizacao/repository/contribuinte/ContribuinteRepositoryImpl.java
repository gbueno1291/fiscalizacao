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

import org.springframework.util.StringUtils;

import com.fiscalizacao.models.Contribuinte;
import com.fiscalizacao.repository.filter.ContribuinteFilter;

public class ContribuinteRepositoryImpl implements ContribuinteRepositoryQuery{

	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Contribuinte> fitrar(ContribuinteFilter contribuinteFilter) {
	    CriteriaBuilder buider = manager.getCriteriaBuilder();
	    CriteriaQuery<Contribuinte> criteria = buider.createQuery(Contribuinte.class);
	    Root<Contribuinte> root  = criteria.from(Contribuinte.class);
	    
	    Predicate[] predicates = criarRestricoes(contribuinteFilter, buider, root );
	    criteria.where(predicates);
	    
	    TypedQuery<Contribuinte> query = manager.createQuery(criteria);
	    return query.getResultList();
		
		
	}

	private Predicate[] criarRestricoes(ContribuinteFilter contribuinteFilter, CriteriaBuilder buider, Root<Contribuinte> root) {
		List<Predicate> predicates = new ArrayList<>();
		if(!StringUtils.isEmpty(contribuinteFilter.getNome())) {
			predicates.add(buider.like(buider.lower(root.get("nome")), "%" + contribuinteFilter.getNome().toLowerCase() + "%"));
		}
		if(!StringUtils.isEmpty(contribuinteFilter.getCpf())) {
			predicates.add(buider.equal(buider.lower(root.get("cpf")), contribuinteFilter.getCpf()));
		}
		if(!StringUtils.isEmpty(contribuinteFilter.getLogradouro())) {
			predicates.add(buider.like(buider.lower(root.get("logradouro")), "%" +contribuinteFilter.getLogradouro().toLowerCase() + "%"));
		}
		if(!StringUtils.isEmpty(contribuinteFilter.getNumero())) {
			predicates.add(buider.equal(buider.lower(root.get("numero")), contribuinteFilter.getNumero()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	
}
