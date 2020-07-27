package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.Bairros;
import com.fiscalizacao.repository.BairrosRepository;

@Service
public class BairrosService {
  
	@Autowired
	BairrosRepository bairrosRepository;
	
	public Bairros findById(Integer id) {
		Bairros bairros = new Bairros();
		try {
			bairros = bairrosRepository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bairros;
	}
	
	public Bairros salvaBairro(Bairros bairros) {
		Bairros novoBairro = new Bairros();
		try {
			novoBairro = bairrosRepository.save(bairros);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novoBairro;
	}
	public void deletaBairro(Integer id) {
		bairrosRepository.deleteById(id);
	}
}
