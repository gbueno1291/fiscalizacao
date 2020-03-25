package com.fiscalizacao.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiscalizacao.models.Parametriza;

@Repository
public interface ParametrizaRepository extends JpaRepository<Parametriza, Integer> {


}
