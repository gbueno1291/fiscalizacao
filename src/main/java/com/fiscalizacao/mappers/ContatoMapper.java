package com.fiscalizacao.mappers;

import org.mapstruct.Mapper;

import com.fiscalizacao.dto.ContatoDTO;
import com.fiscalizacao.models.Contato;

@Mapper
public interface ContatoMapper {
	
	Contato convert(ContatoDTO contatoDTO);
	ContatoDTO convert(Contato contato);

}
