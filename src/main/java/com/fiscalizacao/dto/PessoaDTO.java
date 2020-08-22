package com.fiscalizacao.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {
	
	private String nome;
    private String cpf;
    private String rg;
    private String logo;
	private TipoPessoaDTO tipoPessoa;
	private List<ContatoDTO> contato;
	private List<EnderecoDTO> endereco;

}
