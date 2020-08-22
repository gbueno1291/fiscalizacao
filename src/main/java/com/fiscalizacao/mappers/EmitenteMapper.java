package com.fiscalizacao.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.fiscalizacao.models.Emitente;
import com.fiscalizacao.request.EmitenteRequest;

@Mapper(componentModel = "spring")
public interface EmitenteMapper {

	@Mapping(source = "id", target = "pessoa_id.id")
	Emitente convert(EmitenteRequest emitenteRequest);
	
}