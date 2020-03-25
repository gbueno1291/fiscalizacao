package com.fiscalizacao.service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fiscalizacao.dto.EnderecoDTO;

@Service
public class ViaCepService {
		
	public List<EnderecoDTO> getCepByEndereco(String estado, String cidade,String endereco) {
		RestTemplate restTemplate = new RestTemplate();
		
		String uri = montaURL(estado, cidade, endereco);
		
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
	public ResponseEntity<EnderecoDTO> getEnderecoByCep(String cep) {
		 RestTemplate restTemplate = new RestTemplate();
		    
		    String uri = "http://viacep.com.br/ws/{cep}/json/";
		    
		    Map<String, String> params = new HashMap<String, String>();
		    params.put("cep", cep);
		    EnderecoDTO enderecoDTO = restTemplate.getForObject(uri, EnderecoDTO.class, params);
		    return new ResponseEntity<EnderecoDTO>(enderecoDTO, HttpStatus.OK);
	}
	
	public  String montaURL(String estado,String cidade,String endereco) {
		String cidadeNormalize  = "";
		String enderecoNormalize = "";
		if(!cidade.isEmpty()) {
			cidadeNormalize = Normalizer.normalize(cidade, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		}
		if(!endereco.isEmpty()) {
			enderecoNormalize = Normalizer.normalize(endereco, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		}
		
		String url = "https://viacep.com.br/ws/"+estado+"/"+cidadeNormalize+"/"+enderecoNormalize+"/json/";
	    return url;
	}
}
