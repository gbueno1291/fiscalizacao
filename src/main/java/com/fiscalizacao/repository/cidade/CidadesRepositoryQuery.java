package com.fiscalizacao.repository.cidade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fiscalizacao.models.Cidades;
import com.fiscalizacao.repository.filter.CidadeFilter;


public interface CidadesRepositoryQuery {

	Page<Cidades> filtrar(CidadeFilter cidadeFilter, Pageable pageable);
    
	
}
