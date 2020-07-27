package com.fiscalizacao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.fiscalizacao.models.Bairros;
import com.fiscalizacao.repository.BairrosRepository;
import com.fiscalizacao.repository.filter.BairrosFilter;
import com.fiscalizacao.service.BairrosService;

@RestController
@RequestMapping("/bairros")
public class BairrosController {

	@Autowired
	BairrosRepository repository;
	
	@Autowired
	BairrosService service;
	
	//@GetMapping
	//public ResponseEntity<List<Bairros>> pesquisar(){
	//	List<Bairros> listbairro = repository.findAll();
	//	return ResponseEntity.ok(listbairro);
	//}
	
	@GetMapping
	public Page<Bairros> pesquisar(BairrosFilter bairrosFilter, Pageable pageable){
		return repository.filtrar(bairrosFilter, pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Bairros> buscaPorId(@PathVariable Integer id){
	    Bairros bairro = service.findById(id);
	    return ResponseEntity.ok(bairro);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Bairros> novoBairro(@Valid @RequestBody Bairros bairro){
		Bairros novoBairro = service.salvaBairro(bairro);
		return ResponseEntity.ok(novoBairro);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deletaBairro(@PathVariable Integer id){
		  service.deletaBairro(id);
		  return ResponseEntity.ok(id); 
	}
}
