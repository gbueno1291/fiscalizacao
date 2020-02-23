package com.fiscalizacao.repository.imovel;

import java.util.List;

import com.fiscalizacao.models.Imovel;
import com.fiscalizacao.repository.filter.ImovelFilter;


public interface ImovelRepositoryQuery {

	public List<Imovel> filtrar(ImovelFilter imovelFilter);
}
