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
@RequestMapping("/viacep")
public class ViaCepResource {
	
	@Autowired 
	ViaCepService viaService;
	
	@GetMapping(value="/{estado}/{cidade}/{endereco}")
	  public ResponseEntity<List<EnderecoDTO>> getCepViaEndereco(@PathVariable(name = "estado") String estado,
			  @PathVariable(name = "cidade") String cidade,@PathVariable(name = "endereco") String endereco) {
		  return ResponseEntity.ok().body(viaService.getCepByEndereco(estado,cidade,endereco));
		 
	  }
	@GetMapping(value="/{cep}")
	  public ResponseEntity<EnderecoDTO> getCep(@PathVariable(name = "cep") String cep) {
	    return viaService.getEnderecoByCep(cep);
	  }

}
