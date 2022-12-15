package br.com.netflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.netflix.model.Periodo;
import br.com.netflix.repository.PeriodoRepository;

@RestController
@RequestMapping("/periodo")
public class PeriodoController {
	
	@Autowired
	PeriodoRepository periodoRepository;
	
	@GetMapping
	public List<Periodo> listar(){
		
		return periodoRepository.findAll();
	}

	@GetMapping("/{periodoId}")
	public ResponseEntity<Periodo> buscar(@PathVariable Long periodoId){
	
		java.util.Optional<Periodo> periodo = periodoRepository.findById(periodoId);
		
		if(periodo.isPresent()) {
			return ResponseEntity.ok(periodo.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
	
}
