package com.fiscalizacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fiscalizacao.models.Cidades;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class CidadesDTO {

	private int id;
	private String nome;
	private String uf;
	
	public Cidades transformaParaObj() {
		return new Cidades(id, nome, uf);
	}
}
