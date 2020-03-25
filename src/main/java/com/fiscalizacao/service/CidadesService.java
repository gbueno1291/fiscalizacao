package com.fiscalizacao.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.Cidades;
import com.fiscalizacao.repository.CidadesRepository;

@Service
public class CidadesService {

	@Autowired
	CidadesRepository cidadesRepository;
	
	public Cidades findById(Integer id) {
		Cidades cidades = new Cidades();
		try {
			cidades = cidadesRepository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cidades;
	}
	
	public Cidades SalvaCidades(Cidades cidades) {
		Cidades novaCidades = new Cidades();
		try {
			novaCidades = cidadesRepository.save(cidades);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novaCidades;
	}
	
	public void DeletaCidades (Integer id) {
		cidadesRepository.deleteById(id);
	}

}
