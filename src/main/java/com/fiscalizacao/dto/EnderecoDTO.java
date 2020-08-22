package com.fiscalizacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fiscalizacao.models.Logradouros;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class EnderecoDTO  {

	private LogradouroDTO logradouro;
	private String numero;
	private String complemento;
	
}
