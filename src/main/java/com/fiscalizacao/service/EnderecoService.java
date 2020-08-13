package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.Endereco;
import com.fiscalizacao.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository repository;
	
	public Endereco findById(Integer id) {
		Endereco endereco = new Endereco();
		try {
			endereco = repository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return endereco;
	}
	
	public Endereco salvaEndereco(Endereco endereco) {
		Endereco novoEndereco = new Endereco();
		try {
			novoEndereco = repository.save(endereco);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novoEndereco;
	}
	
	public void deletaEndereco(Integer id) {
		repository.deleteById(id);
	}
}
