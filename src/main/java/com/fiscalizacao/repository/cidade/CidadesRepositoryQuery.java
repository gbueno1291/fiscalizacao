package com.fiscalizacao.repository.cidade;

import java.util.List;


import com.fiscalizacao.models.Cidades;
import com.fiscalizacao.repository.filter.CidadeFilter;


public interface CidadesRepositoryQuery {

	public List<Cidades> filtrar(CidadeFilter cidadeFilter);
}
