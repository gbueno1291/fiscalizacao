package com.fiscalizacao.mappers;

import org.mapstruct.Mapper;

import com.fiscalizacao.dto.EnderecoDTO;
import com.fiscalizacao.models.Endereco;

@Mapper
public interface EnderecoMapper {
	
	Endereco converter(EnderecoDTO enderecoDTO);
	EnderecoDTO converter(Endereco endereco);
}
