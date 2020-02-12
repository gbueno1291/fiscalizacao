package com.fiscalizacao.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiscalizacao.dto.EnderecoDTO;
import com.fiscalizacao.service.ViaCepService;

@RestController
@RequestMapping("/viaCep")
public class ViaCepResource {
	
	@Autowired 
	ViaCepService viaService;
	
	@GetMapping(value="/getCep/{cep}")
	  public ResponseEntity<List<EnderecoDTO>> getCep(@PathVariable(name = "cep") String cep) {
		  return ResponseEntity.ok().body(viaService.getEndereço(cep));
		 
	  }
}
