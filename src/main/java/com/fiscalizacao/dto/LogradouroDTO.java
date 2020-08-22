package com.fiscalizacao.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogradouroDTO {
	
	private TipoLogradouroDTO tipologradouro;
	private String nome;
	private String cep;
	private BairroDTO bairro;



}
