package com.fiscalizacao.repository.contribuinte;

import java.util.List;

import com.fiscalizacao.models.Contribuinte;
import com.fiscalizacao.repository.filter.ContribuinteFilter;

public interface ContribuinteRepositoryQuery {

	public List<Contribuinte> filtrar(ContribuinteFilter contribuinteFilter);
}
