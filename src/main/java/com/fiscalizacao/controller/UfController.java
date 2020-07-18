package com.fiscalizacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiscalizacao.models.Uf;
import com.fiscalizacao.repository.UfRepository;
import com.fiscalizacao.service.UfService;

@RestController
@RequestMapping("/uf")
public class UfController {

	@Autowired
	UfRepository ufRepository;
	
	@Autowired
	UfService ufService;
	
	@GetMapping
	public ResponseEntity<List<Uf>> pesquisar(){
		 List<Uf> ListUf = ufRepository.findAll();
		 return ResponseEntity.ok(ListUf);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Uf>  buscaPorId(@PathVariable Integer id){
		Uf uf = ufService.findById(id);
		return ResponseEntity.ok(uf);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Uf> novasUf(@Valid @RequestBody Uf uf){
		Uf novaUf = ufService.salvaUf(uf);
		return ResponseEntity.ok(novaUf);
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deletaCidade(@PathVariable Integer id){
    	ufService.deletaUf(id);
    	return ResponseEntity.ok(id);
    }
	
}
