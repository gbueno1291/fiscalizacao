package com.fiscalizacao.repository.bairros;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fiscalizacao.models.Bairros;
import com.fiscalizacao.repository.filter.BairrosFilter;

public interface BairrosRepositoryQuery {
	Page<Bairros> filtrar(BairrosFilter bairrosFilter, Pageable pageable);

}
