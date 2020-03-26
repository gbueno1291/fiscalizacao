package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.exceptionHandler.CPFInvalidoException;
import com.fiscalizacao.models.Contribuinte;
import com.fiscalizacao.repository.ContribuinteRepository;
import com.fiscalizacao.utils.Utils;

@Service
public class ContribuinteService {

	@Autowired
	ContribuinteRepository contribuinteRepository;
	
	public Contribuinte findById(Integer id) {
		Contribuinte contribuinte = new Contribuinte();
		try {
			contribuinte = contribuinteRepository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contribuinte;
	}
	
	public Contribuinte salvaContribuinte(Contribuinte contribuinte) throws CPFInvalidoException {
		Contribuinte novoContribuinte = new Contribuinte();
			if (!Utils.isCPF(contribuinte.getCpf())) {
				throw new CPFInvalidoException();
			}
			novoContribuinte = contribuinteRepository.save(contribuinte);

		return novoContribuinte;
	}
	
	public void deletaContribuinte(Integer id) {
		contribuinteRepository.deleteById(id);
		
	}

	
}
