package com.fiscalizacao.repository.imovel;

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
import com.fiscalizacao.models.Imovel;
import com.fiscalizacao.repository.filter.ContribuinteFilter;
import com.fiscalizacao.repository.filter.ImovelFilter;

public class ImovelRepositoryImpl implements ImovelRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Imovel> filtrar(ImovelFilter imovelFilter) {
		    CriteriaBuilder buider = manager.getCriteriaBuilder();
		    CriteriaQuery<Imovel> criteria = buider.createQuery(Imovel.class);
		    Root<Imovel> root  = criteria.from(Imovel.class);
		    
		    Predicate[] predicates = criarRestricoes(imovelFilter, buider, root );
		    criteria.where(predicates);
		    
		    TypedQuery<Imovel> query = manager.createQuery(criteria);
		    return query.getResultList();
			
	}

	private Predicate[] criarRestricoes(ImovelFilter imovelFilter, CriteriaBuilder buider, Root<Imovel> root) {
        List<Predicate> predicates = new ArrayList<>();
		
		/*if(!StringUtils.isEmpty(imovelFilter.getCadastro())) {
			predicates.add(buider.equal(buider.lower(root.get("cadastro")), imovelFilter.getCadastro()));
		}*/
		if(!StringUtils.isEmpty(imovelFilter.getLogradouro())) {
			predicates.add(buider.like(buider.lower(root.get("logradouro")), "%" +imovelFilter.getLogradouro().toLowerCase() + "%"));
		}
		if(!StringUtils.isEmpty(imovelFilter.getNumero())) {
			predicates.add(buider.equal(buider.lower(root.get("numero")), imovelFilter.getNumero()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
