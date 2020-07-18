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

import com.fiscalizacao.models.TipoLogradouro;
import com.fiscalizacao.repository.TipoLogradouroRepository;
import com.fiscalizacao.service.TipoLogradourosService;

@RestController
@RequestMapping("/tplogradouro")
public class TipoLogradouroController {

	@Autowired
	TipoLogradouroRepository repository;
	
	@Autowired
	TipoLogradourosService service;
	
	@GetMapping
	public ResponseEntity<List<TipoLogradouro>> pesquisar(){
		List<TipoLogradouro> listLogradouro = repository.findAll();
		return ResponseEntity.ok(listLogradouro);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoLogradouro> buscaPorId(@PathVariable Integer id){
		TipoLogradouro tipoLogradouro = service.findById(id);
		return ResponseEntity.ok(tipoLogradouro);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<TipoLogradouro> novoLogradouro(@Valid @RequestBody TipoLogradouro tipoLog){
		TipoLogradouro novoTpLogradouro = service.novoLogradouro(tipoLog);
		return ResponseEntity.ok(novoTpLogradouro);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deletaLogradouro(@PathVariable Integer id){
		service.deletaLogradouro(id);
		return ResponseEntity.ok(id);
	}
	
}
