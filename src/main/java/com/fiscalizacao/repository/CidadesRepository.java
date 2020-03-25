package com.fiscalizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fiscalizacao.models.Cidades;
import com.fiscalizacao.repository.cidade.CidadesRepositoryQuery;


@Repository
public interface CidadesRepository extends JpaRepository<Cidades, Integer>, CidadesRepositoryQuery {
	
}
