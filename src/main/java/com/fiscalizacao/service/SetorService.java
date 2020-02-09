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
	
	public Setor salvarSetor(Setor setor) {
		
		  Setor novoSetor = new Setor();
		try {
			
		    novoSetor = setorRepository.save(setor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  novoSetor;
	}
	public void  deletarSetor(Integer id) {
        setorRepository.deleteById(id);
       
//	     if(id != null ) {
//		    setor = setorRepository.findById(id).orElse(null);
//		    if(setor !=null) {
//		    	try {
//				    setorRepository.delete(setor);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				return  setor;
//		    }
//		 }
//         return null;
	}
}
