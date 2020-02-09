package com.fiscalizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiscalizacao.models.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer>{

}
