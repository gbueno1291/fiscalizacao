package com.fiscalizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiscalizacao.models.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Integer> {

}