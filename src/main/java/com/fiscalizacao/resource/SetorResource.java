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

import com.fiscalizacao.models.Setor;
import com.fiscalizacao.repository.SetorRepository;
import com.fiscalizacao.service.SetorService;


@RestController
@RequestMapping("/setor")
public class SetorResource {
	@Autowired 
	SetorService setorService;
	
	@Autowired
	SetorRepository setorRepository;
	
	@GetMapping
	public ResponseEntity<List<Setor>> findAll(){
		List<Setor>  listSetor = setorRepository.findAll();
		return ResponseEntity.ok(listSetor);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Setor> buscarSetorPorId(@PathVariable Integer id){
		Setor setor  = setorService.findById(id); 
		return ResponseEntity.ok(setor);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Setor> cadastrarSetor(@Valid @RequestBody Setor setor) {
	   Setor set = setorService.salvarSetor(setor);
       return ResponseEntity.ok(set);
	}
	
    @DeleteMapping("/{id}") 
    public ResponseEntity<Integer> deleteSetorId(@PathVariable Integer id) {
            setorService.deletarSetor(id);
              return ResponseEntity.ok(id);
    }
	

	

}
