package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.Pessoa;
import com.fiscalizacao.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository repository;
	
	public Pessoa findById(Integer id) {
		Pessoa pessoa = new Pessoa();
		try {
			pessoa = repository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pessoa;
	}
	
	public Pessoa salvaPessoa(Pessoa pessoa) {
		Pessoa novaPessoa = new Pessoa();
		try {
			novaPessoa = repository.save(pessoa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novaPessoa;
	}
	
	public void deletaPessoa(Integer id) {
		repository.deleteById(id);
	}
}
