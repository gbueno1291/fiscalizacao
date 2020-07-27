package com.fiscalizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiscalizacao.models.Bairros;
import com.fiscalizacao.repository.bairros.BairrosRepositoryQuery;

@Repository
public interface BairrosRepository extends JpaRepository<Bairros, Integer>, BairrosRepositoryQuery{

}
