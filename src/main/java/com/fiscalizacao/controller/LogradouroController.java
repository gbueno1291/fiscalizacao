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

import com.fiscalizacao.models.Logradouros;
import com.fiscalizacao.repository.LogradourosRepository;
import com.fiscalizacao.service.LogradouroService;

@RestController
@RequestMapping("/logradouros")
public class LogradouroController {

	@Autowired
	LogradourosRepository repository;
	
	@Autowired
	LogradouroService service;
	
	@GetMapping
	public ResponseEntity<List<Logradouros>> pesquisar(){
		List<Logradouros> listLogradouros = repository.findAll();
		return ResponseEntity.ok(listLogradouros);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Logradouros> logradouroPorId(@PathVariable Integer id){
		Logradouros logradouros = service.findById(id);
		return ResponseEntity.ok(logradouros);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Logradouros> novoLogradouro(@Valid @RequestBody Logradouros logradouro){
		Logradouros novoLogradouro = service.novologradouro(logradouro);
		return ResponseEntity.ok(novoLogradouro);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deletaLogradouro(@PathVariable Integer id){
		service.deletaLogradouro(id);
		return ResponseEntity.ok(id);
	}
}
