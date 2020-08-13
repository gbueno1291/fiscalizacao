package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.Contato;
import com.fiscalizacao.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	ContatoRepository repository;
	
	public Contato findById(Integer id) {
		Contato contato = new Contato();
		try {
			contato = repository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contato;
	}
	
	public Contato salvaContato(Contato contato) {
		Contato novoContato = new Contato();
		try {
			novoContato = repository.save(contato);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novoContato;
	}
	
   public void deletaContato(Integer id) {
	   repository.deleteById(id);
   }
}
