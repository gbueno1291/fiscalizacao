package com.fiscalizacao.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BairroDTO {

	private String nome;
	private int setor;
	private CidadeDTO cidade;
	
}
