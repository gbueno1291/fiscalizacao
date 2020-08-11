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

import com.fiscalizacao.models.TipoPessoa;
import com.fiscalizacao.repository.TipoPessoaRepository;
import com.fiscalizacao.service.TipoPessoaService;

@RestController
@RequestMapping("/tipopessoa")
public class TipoPessoaController {

	@Autowired
	TipoPessoaRepository repository;
	
	@Autowired
	TipoPessoaService service;
	
	@GetMapping
	public ResponseEntity<List<TipoPessoa>> pesquisar(){
		List<TipoPessoa> tipopessoa = repository.findAll();
		return ResponseEntity.ok(tipopessoa);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoPessoa>  buscaPorId(@PathVariable Integer id){
		TipoPessoa buscaTipoPessoa = new TipoPessoa();
		buscaTipoPessoa = service.findById(id);
		return ResponseEntity.ok(buscaTipoPessoa);
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<TipoPessoa> novaTipoPessoa(@Valid @RequestBody TipoPessoa tipoPessoa){
		TipoPessoa nova = new TipoPessoa();
		nova = service.salvaTipoPessoa(tipoPessoa);
	    return ResponseEntity.ok(nova);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deleta(@PathVariable Integer id){
		service.deletaPessoa(id);
		return ResponseEntity.ok(id);
	}

}
