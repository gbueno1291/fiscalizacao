package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.Uf;
import com.fiscalizacao.repository.UfRepository;

@Service
public class UfService {

	@Autowired
	UfRepository ufRepository;
	
	public Uf findById(Integer id) {
		Uf uf = new Uf();
		try {
			uf = ufRepository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		 return uf;
		}
	
	public Uf salvaUf(Uf uf) {
		Uf novoUf = new Uf();
		try {
			novoUf = ufRepository.save(uf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novoUf;
	}
	public void deletaUf(Integer id) {
		ufRepository.deleteById(id);
	}
	
	
}
