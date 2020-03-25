package com.fiscalizacao.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.exceptionHandler.MsgException;
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
	
	public Contribuinte SalvaContribuinte(Contribuinte contribuinte) {
		Contribuinte novoContribuinte = new Contribuinte();
	   try {
		   if(!Utils.isCPF(contribuinte.getCpf())) {
		       throw new MsgException("Cpf Invalido","Informe um CPF valido!" );
		   }
		   novoContribuinte = contribuinteRepository.save(contribuinte);
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return novoContribuinte;
	}
	
	public void deletaContribuinte(Integer id) {
		contribuinteRepository.deleteById(id);
		
	}

	
}
