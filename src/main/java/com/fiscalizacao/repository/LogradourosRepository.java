package com.fiscalizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiscalizacao.models.Logradouros;

@Repository
public interface LogradourosRepository extends JpaRepository<Logradouros, Integer> {

}
