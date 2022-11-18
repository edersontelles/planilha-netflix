package br.com.netflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.netflix.model.Planilha;
import br.com.netflix.repository.PlanilhaRepository;

@RestController
@RequestMapping("/planilha")
public class PlanilhaController {

	@Autowired
	private PlanilhaRepository planilhaRepository; 
	
	@GetMapping
	public List<Planilha> buscar() {
		
		return planilhaRepository.findAll(); 
		
		
	}
}
