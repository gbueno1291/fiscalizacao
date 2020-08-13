package com.fiscalizacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiscalizacao.models.Endereco;
import com.fiscalizacao.repository.EnderecoRepository;
import com.fiscalizacao.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	EnderecoRepository repository;
	
	@Autowired
	EnderecoService service;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> pesquisar(){
		List<Endereco> listar = repository.findAll();
		return ResponseEntity.ok(listar);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> buscaPorId(@PathVariable Integer id){
		Endereco listaEndereco = service.findById(id);
		return ResponseEntity.ok(listaEndereco);
	}
	@PostMapping
	public ResponseEntity<Endereco> novoEndereco(@Valid @RequestBody Endereco endereco){
		Endereco novo = service.salvaEndereco(endereco);
		return ResponseEntity.ok(novo);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> delete(@PathVariable Integer id){
		service.deletaEndereco(id);
		return ResponseEntity.ok(id);
	}
}
