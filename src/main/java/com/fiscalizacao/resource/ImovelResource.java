package com.fiscalizacao.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiscalizacao.models.Contribuinte;
import com.fiscalizacao.models.Imovel;
import com.fiscalizacao.repository.ContribuinteRepository;
import com.fiscalizacao.repository.ImovelRepository;

import com.fiscalizacao.repository.filter.ImovelFilter;

import com.fiscalizacao.service.ContribuinteService;
import com.fiscalizacao.service.ImovelService;

@RestController
@RequestMapping("/imovel")
public class ImovelResource {
	@Autowired
	ImovelRepository imovelRepository;
	
	@Autowired
	ImovelService imovelService;
	
	@GetMapping
	public List<Imovel>  pesquisar(ImovelFilter imovelFilter){
		return imovelRepository.filtrar(imovelFilter);
	}
	public ResponseEntity<List<Imovel>> findAll(){
		List<Imovel>  listImovel = imovelRepository.findAll();
		return ResponseEntity.ok(listImovel);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Imovel> buscarImovelPorId(@PathVariable Integer id){
		Imovel imovel  = imovelService.findById(id); 
		return ResponseEntity.ok(imovel);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Imovel> cadastrarImovel(@Valid @RequestBody Imovel imovel) {
		Imovel gravaImovel = imovelService.SalvaImovel(imovel);
       return ResponseEntity.ok(gravaImovel);
	}

    @DeleteMapping("/{id}") 
    public ResponseEntity<Integer> deleteImovelId(@PathVariable Integer id) {
    	imovelService.deletaImovel(id);
              return ResponseEntity.ok(id);
    }
}
