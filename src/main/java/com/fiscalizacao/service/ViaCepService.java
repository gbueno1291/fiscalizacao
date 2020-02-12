package com.fiscalizacao.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fiscalizacao.configs.URLProperties;
import com.fiscalizacao.configs.URLProperties.ApiExterna;
import com.fiscalizacao.dto.EnderecoDTO;

@Service
public class ViaCepService {
	
	@Autowired
	private ApiExterna apiExterna;
	
	public List<EnderecoDTO> getEndereço(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		
		String uri = apiExterna.getExterior().get("viacep");
		

		Map<String, String> params = new HashMap<String, String>();
		params.put("cep", cep);
		List<EnderecoDTO> enderecosDTO = new ArrayList<>();
		try {
			ResponseEntity<List<EnderecoDTO>> listEnderecoRest = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<EnderecoDTO>>() {
					});
			
			enderecosDTO = listEnderecoRest.getBody();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return enderecosDTO;

	}

}
