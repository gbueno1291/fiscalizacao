package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.exceptionHandler.EmitenteCadastradoException;
import com.fiscalizacao.exceptionHandler.EmitenteExistenteException;
import com.fiscalizacao.mappers.EmitenteMapper;
import com.fiscalizacao.models.Emitente;
import com.fiscalizacao.repository.EmitenteRepository;
import com.fiscalizacao.request.EmitenteRequest;
import com.fiscalizacao.validate.EmitenteValidate;

@Service
public class EmitenteService {
  
	@Autowired
	EmitenteRepository emitenteRepository;
	
	@Autowired
	EmitenteMapper emitenteMapper;
	
	@Autowired
	EmitenteValidate emitenteValidate;
	
	public Emitente findById(Integer id) {
		Emitente emitente = new Emitente();
		try {
			emitente = emitenteRepository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emitente;
	}
	
	public Emitente salvaEmitente(EmitenteRequest emitenteRequest) throws EmitenteCadastradoException {
		emitenteValidate.validateRequest(emitenteRequest);
		Emitente emitente = emitenteMapper.convert(emitenteRequest);
		Emitente novoEmitente = new Emitente();
		
	   try {

		   if(emitenteRepository.countEmitente() > 0 ) {
			   throw new EmitenteExistenteException();
		   }
		   
		   novoEmitente = emitenteRepository.save(emitente);
	
	   } catch (Exception e) {
		e.printStackTrace();
	}
	   return novoEmitente;
	}
	
	public void deletaEmitente(Integer id) {
		emitenteRepository.deleteById(id);
		
	}
	
}
