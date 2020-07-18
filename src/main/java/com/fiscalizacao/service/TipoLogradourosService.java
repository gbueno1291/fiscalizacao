package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.TipoLogradouro;
import com.fiscalizacao.repository.TipoLogradouroRepository;

@Service
public class TipoLogradourosService {

	@Autowired
	TipoLogradouroRepository repository;
	
	public TipoLogradouro findById(Integer id) {
		TipoLogradouro tplogradouro = new TipoLogradouro();
		try {
			tplogradouro = repository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tplogradouro;
	}
	
	public TipoLogradouro novoLogradouro(TipoLogradouro tplog) {
		TipoLogradouro novotpLogradouro = new TipoLogradouro();
		try {
			novotpLogradouro = repository.save(tplog);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novotpLogradouro;
	}
	public void deletaLogradouro(Integer id) {
		repository.deleteById(id);
	}
}
