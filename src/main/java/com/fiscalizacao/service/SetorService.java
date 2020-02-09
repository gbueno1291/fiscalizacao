package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.Setor;
import com.fiscalizacao.repository.SetorRepository;


@Service
public class SetorService {

	@Autowired
	SetorRepository setorRepository;
	
	public Setor findById(Integer id) {
		Setor set = new Setor();
		try {
			set = setorRepository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return set;
	}
	
}
