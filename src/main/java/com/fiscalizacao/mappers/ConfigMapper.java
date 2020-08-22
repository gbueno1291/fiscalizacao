package com.fiscalizacao.mappers;

import org.mapstruct.Mapper;

import com.fiscalizacao.dto.ConfigDTO;
import com.fiscalizacao.models.Config;

@Mapper
public interface ConfigMapper {
	
	Config converter(ConfigDTO configDTO);
	ConfigDTO converter(Config config);

}
