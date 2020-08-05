package com.fiscalizacao.repository.contribuinte;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fiscalizacao.models.Contribuinte;
import com.fiscalizacao.repository.filter.ContribuinteFilter;

public interface ContribuinteRepositoryQuery {

	Page<Contribuinte> fitrar(ContribuinteFilter contribuinteFilter, Pageable pageable);
}
