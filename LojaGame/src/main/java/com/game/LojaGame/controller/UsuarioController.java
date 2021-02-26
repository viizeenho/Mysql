package com.game.LojaGame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.LojaGame.model.Usuario;
import com.game.LojaGame.repository.UsuarioRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	//Retorna uma lista de usuarios
	@GetMapping
	public ResponseEntity<List<Usuario>> getByALL(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//Retorna um usuario por ID
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById (@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	//Retorna Usuario pelo nome
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> getByNome (@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}

	//Adicionando usuario na tabela
	@PostMapping
	public ResponseEntity<Usuario> post (@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));

	}
	
	//Faz alteracoes em usuarios ja cadastrado
	@PutMapping
	public ResponseEntity<Usuario> put (@RequestBody Usuario usuario){
		return ResponseEntity.ok(repository.save(usuario));
	}
	
	//deleta um usuario do banco
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
	


}