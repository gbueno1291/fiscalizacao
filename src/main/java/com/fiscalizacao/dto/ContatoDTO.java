package com.fiscalizacao.dto;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoDTO {

	private String email;
	private String site;
	private String telefone;
	public String responsavel;
}
