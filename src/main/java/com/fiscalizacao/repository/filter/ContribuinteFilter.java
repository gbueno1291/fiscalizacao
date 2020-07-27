package com.fiscalizacao.repository.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContribuinteFilter {
    private String nome;
    private String cpf;
    private String logradouro;
    private String numero;
}
