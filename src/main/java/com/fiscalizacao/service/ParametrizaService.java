package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.Parametriza;
import com.fiscalizacao.repository.ParametrizaRepository;

@Service
public class ParametrizaService {

	@Autowired
	ParametrizaRepository parametrizaRepository;
	
	public Parametriza findById(Integer id) {
		Parametriza parametriza  = new Parametriza();
		try {
			parametriza = parametrizaRepository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parametriza;
	}
	public Parametriza SalvaParametriza(Parametriza parametriza) {
		 Parametriza novoParametriza = new Parametriza();
		 try {
			novoParametriza = parametrizaRepository.save(parametriza);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return novoParametriza;
	}
	public void deletaParametriza(Integer id) {
		 parametrizaRepository.deleteById(id);
	}
}
