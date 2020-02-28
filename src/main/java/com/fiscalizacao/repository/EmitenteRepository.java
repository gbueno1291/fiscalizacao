package com.fiscalizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiscalizacao.models.Emitente;

@Repository
public interface EmitenteRepository extends JpaRepository<Emitente, Integer>{

}
