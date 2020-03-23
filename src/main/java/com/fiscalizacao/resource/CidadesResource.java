package com.fiscalizacao.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiscalizacao.dto.CidadesDTO;
import com.fiscalizacao.models.Cidades;
import com.fiscalizacao.repository.CidadesRepository;
import com.fiscalizacao.repository.filter.CidadeFilter;
import com.fiscalizacao.service.CidadesService;

@RestController
@RequestMapping("/cidades")
public class CidadesResource {

	@Autowired
	CidadesRepository cidadesRepository;
	
	@Autowired
	CidadesService cidadesService;
	
	@GetMapping
	public List<Cidades> pesquisar(CidadeFilter cidadeFilter){
		 return cidadesRepository.filtrar(cidadeFilter);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cidades>  buscaPorId(@PathVariable Integer id){
		Cidades cidades = cidadesService.findById(id);
		return ResponseEntity.ok(cidades);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cidades> novaCidade(@Valid @RequestBody CidadesDTO dto){
		Cidades novaCidade = cidadesService.SalvaCidades(dto.transformaParaObj());
		return ResponseEntity.ok(novaCidade);
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deletaCidade(@PathVariable Integer id){
    	cidadesService.DeletaCidades(id);
    	return ResponseEntity.ok(id);
    }
    
}
