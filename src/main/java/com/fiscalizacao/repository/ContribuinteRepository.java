package com.fiscalizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiscalizacao.models.Contribuinte;
<<<<<<< HEAD
import com.fiscalizacao.repository.contribuinte.ContribuinteRepositoryQuery;

@Repository
public interface ContribuinteRepository extends JpaRepository<Contribuinte, Integer>, ContribuinteRepositoryQuery {
=======

@Repository
public interface ContribuinteRepository extends JpaRepository<Contribuinte, Integer> {
>>>>>>> remodelagemDB

}
