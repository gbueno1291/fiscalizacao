package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.mappers.PessoaMapper;
import com.fiscalizacao.models.Pessoa;
import com.fiscalizacao.repository.PessoaRepository;
import com.fiscalizacao.response.PessoaResponse;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository repository;
	
	@Autowired
	PessoaMapper pessoaMapper;
	
	public PessoaResponse findById(Integer id) {
		PessoaResponse pessoaResponse = new PessoaResponse();
		
		
		try {
			Pessoa pessoa  = repository.findById(id).orElse(null);
			pessoaResponse.setPessoa(pessoaMapper.convert(pessoa));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pessoaResponse;
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
