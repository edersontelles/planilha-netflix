package br.com.netflix.controller;

import java.util.List;

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

import br.com.netflix.model.Usuario;
import br.com.netflix.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> listar(){
		return usuarioRepository.findAll();
	//return usuarioRepository.findByNome("Ederson");
	//return usuarioRepository.findByNomeContaining("e");
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long userId) {
		java.util.Optional<Usuario> user = usuarioRepository.findById(userId);
		
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)	
	public Usuario adcionar(@RequestBody Usuario user) {
		
		return usuarioRepository.save(user);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long userId, @RequestBody Usuario user){
		
		
		if(!usuarioRepository.existsById(userId)) {
			return ResponseEntity.notFound().build();
		}
		
		user.setId(userId);
		user = usuarioRepository.save(user);
		
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> remover(@PathVariable Long userId){
		
		if(!usuarioRepository.existsById(userId)) {
			return ResponseEntity.notFound().build();
		}
		
		usuarioRepository.deleteById(userId);
		
		return ResponseEntity.noContent().build();
	}
	
}
