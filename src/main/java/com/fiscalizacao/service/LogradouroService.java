package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.Logradouros;
import com.fiscalizacao.repository.LogradourosRepository;

@Service
public class LogradouroService {

	@Autowired
	LogradourosRepository repository;
	
	public Logradouros findById(Integer id) {
		Logradouros logradouro = new Logradouros();
		try {
			logradouro = repository.findById(id).orElse(null);
					} catch (Exception e) {
			e.printStackTrace();
		}
		return logradouro;
	}
	
	public Logradouros novologradouro(Logradouros logradouro) {
		Logradouros novoLogradouro = new Logradouros();
		try {
			novoLogradouro = repository.save(logradouro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novoLogradouro;
	}
	public void deletaLogradouro(Integer id) {
		repository.deleteById(id);
	}
}
