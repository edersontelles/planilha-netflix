package br.com.netflix.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.netflix.model.Planilha;
import br.com.netflix.model.Usuario;
import br.com.netflix.repository.PlanilhaRepository;
import br.com.netflix.repository.UsuarioRepository;

@RestController
@RequestMapping("/planilha")
public class PlanilhaController {

	@Autowired
	private PlanilhaRepository planilhaRepository;

//	@GetMapping
//	public Planilha buscar() {
//		
//		ArrayList<Planilha> p = new ArrayList<>();
//
//		p.addAll(planilhaRepository.findAll());
//		
//		return p.get(0);
//	}

	/*
	 * @GetMapping public List<Planilha> buscarSituacao() {
	 * 
	 * return planilhaRepository.findByUsuarioSituacao(1, 2); }
	 */

	@GetMapping("/{ids}")
	public Planilha buscarSit(@PathVariable int[] ids) {

		ArrayList<Planilha> planilha = new ArrayList<>();

		int mes = ids[0];
		long user = ids[1];

		planilha.addAll(planilhaRepository.findByUsuarioSituacao(mes, user));

		return planilha.get(0);
	}
}
