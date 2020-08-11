package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.TipoPessoa;
import com.fiscalizacao.repository.TipoPessoaRepository;

@Service
public class TipoPessoaService {
	
	@Autowired
	TipoPessoaRepository repository;
	
	public TipoPessoa  findById(Integer id) {
		TipoPessoa tipoPessoa = new TipoPessoa();
		try {
			tipoPessoa = repository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoPessoa;
	}
	
	public TipoPessoa  salvaTipoPessoa(TipoPessoa tipoPessoa) {
		TipoPessoa novoTipoPessoa = new TipoPessoa();
		try {
			novoTipoPessoa = repository.save(tipoPessoa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novoTipoPessoa;
	}
	
	public void deletaPessoa(Integer id) {
		repository.deleteById(id);
	}

}
