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

import com.fiscalizacao.models.Imovel;
import com.fiscalizacao.repository.filter.ImovelFilter;

public class ImovelRepositoryImpl implements ImovelRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Imovel> filtrar(ImovelFilter imovelFilter) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Imovel> criteria = builder.createQuery(Imovel.class);
		Root<Imovel> root = criteria.from(Imovel.class);
		
		//criar restrições
		Predicate[] predicates = criarRestricoes(imovelFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Imovel> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(ImovelFilter imovelFilter, CriteriaBuilder builder, Root<Imovel> root) {
		
		List<Predicate> predicates = new ArrayList();
		
		//where cadastro like '%pesquisa%'
		//if (!StringUtils.isEmpty(imovelFilter.getCadastro())) {
			//predicates.add(builder.equal(root.get("cadastro"), imovelFilter.getCadastro()));
		//}
		if (!StringUtils.isEmpty(imovelFilter.getLogradouro())) {
			predicates.add(builder.like(
					builder.lower(root.get("logradouro")), "%"+ imovelFilter.getLogradouro().toLowerCase() +"%"));		
		}
		if (!StringUtils.isEmpty(imovelFilter.getNumero())) {
		    predicates.add(
		    		builder.like(builder.lower(root.get("numero")),"%"+ imovelFilter.getNumero().toLowerCase() +"%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
