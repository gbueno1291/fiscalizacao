package com.fiscalizacao.repository.logradouros;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fiscalizacao.models.Logradouros;
import com.fiscalizacao.repository.filter.LogradourosFilter;

public interface LogradourosRepositoryQuery {

	Page<Logradouros> filtrar(LogradourosFilter logradourosFilter, Pageable pageable);
}
