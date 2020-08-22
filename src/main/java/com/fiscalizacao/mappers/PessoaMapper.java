package com.fiscalizacao.mappers;

import org.mapstruct.Mapper;

import com.fiscalizacao.dto.PessoaDTO;
import com.fiscalizacao.models.Pessoa;

@Mapper(componentModel = "spring")
public interface PessoaMapper {
	
	PessoaDTO convert(Pessoa pessoa);
	
	Pessoa convert(PessoaDTO pessoaDTO);

}
