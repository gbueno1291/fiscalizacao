package com.fiscalizacao.repository.uf;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fiscalizacao.models.Uf;
import com.fiscalizacao.repository.filter.UfFilter;

public interface UfRepositoryQuery {

	Page<Uf> filtrar(UfFilter ufFilter, Pageable pagable);
}
