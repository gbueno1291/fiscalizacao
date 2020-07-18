package com.fiscalizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiscalizacao.models.TipoLogradouro;

@Repository
public interface TipoLogradouroRepository extends JpaRepository<TipoLogradouro, Integer>{

}
