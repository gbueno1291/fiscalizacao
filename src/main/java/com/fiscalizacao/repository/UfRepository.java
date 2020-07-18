package com.fiscalizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiscalizacao.models.Uf;

@Repository
public interface UfRepository  extends JpaRepository<Uf, Integer>{

}
