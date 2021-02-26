package com.game.LojaGame.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.game.LojaGame.model.Categoria;
import com.game.LojaGame.repository.CategoriaRepository;



@RestController
@CrossOrigin("*")
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	//Retornar uma lista com todas as categorias
	@GetMapping
	public ResponseEntity<List<Categoria>> getByAll(){
		return ResponseEntity.ok(repository.findAll()); 	
	}
	
	// retorna a categoria por id
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById (@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	// retorna categoria pelo nome
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categoria>> getByName (@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeCategoriaContainingIgnoreCase(nome));
	}
	// adicionar categoria
	@PostMapping
	public ResponseEntity<Categoria> post (@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	// alterar categoria
	@PutMapping
	public ResponseEntity<Categoria> put (@RequestBody Categoria categoria){
		return ResponseEntity.ok(repository.save(categoria));
	}
	// deletar categoria
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
