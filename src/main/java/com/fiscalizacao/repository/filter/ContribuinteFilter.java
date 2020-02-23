package com.fiscalizacao.repository.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContribuinteFilter {

	private String cpf;
	private String nome;
	private String logradouro;
	private String numero;
}
