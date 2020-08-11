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

import com.fiscalizacao.models.Contato;
import com.fiscalizacao.repository.ContatoRepository;
import com.fiscalizacao.service.ContatoService;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    
	@Autowired
	ContatoRepository repository;
	
	@Autowired
	ContatoService service;
	
	@GetMapping
	public ResponseEntity<List<Contato>> pesquisar(){
		List<Contato> todosContatos = repository.findAll();
		return ResponseEntity.ok(todosContatos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contato> contatoPorId(@PathVariable Integer id){
		Contato listaContato = service.findById(id);
		return ResponseEntity.ok(listaContato);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Contato>  novoContato(@Valid @RequestBody Contato contato){
		Contato novo = new Contato();
		novo = service.salvaContato(contato);
		return ResponseEntity.ok(novo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deleta(@PathVariable Integer id){
		service.deletaContato(id);
		return ResponseEntity.ok(id);
	}
}
