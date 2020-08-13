package com.fiscalizacao.dto;



import com.fiscalizacao.models.Pessoa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoDTO {
	
	private Pessoa pessoa;
	public String email;
	public String site;
	public String responsavel;
}
