package com.fiscalizacao.dto;

import com.fiscalizacao.models.Bairros;
import com.fiscalizacao.models.TipoLogradouro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogradourosDTO {

	private int id;
	public Bairros bairro;
	public TipoLogradouro tipologradouro;
	public String nome;
	public String cep;
}
