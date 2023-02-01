package com.attornatus.procuradoriaDigital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.procuradoriaDigital.entities.Pessoa;
import com.attornatus.procuradoriaDigital.repositories.PessoaRepository;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	//Find all list
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() { 
		List<Pessoa> lista = pessoaRepository.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	//Find By Id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Integer id) {
		if (pessoaRepository.existsById(id)) {
			Pessoa resultado = pessoaRepository.findById(id).get();
			return ResponseEntity.ok().body(resultado);
		}
		return ResponseEntity.notFound().build();
	}
	
	//Save information with RequestBody
	@PostMapping
	public ResponseEntity<Pessoa> created(@RequestBody Pessoa pessoa) {
		Pessoa resultado = pessoaRepository.save(pessoa);
		return ResponseEntity.ok().body(resultado);
	}
	
	//Update
	@PutMapping
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa) {
		Pessoa atualizacao = pessoaRepository.save(pessoa);
		return ResponseEntity.ok().body(atualizacao);
	}
	
	//Delete Person
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Integer id) {
		if (pessoaRepository.existsById(id)) {
			pessoaRepository.deleteById(id);
		}
	}
	
	//Find by name of the Person
	@GetMapping(value = "/buscar")
	public ResponseEntity<List<Pessoa>> findPerson(Pessoa find) {
		ExampleMatcher matcher = ExampleMatcher.matching()
												.withIgnoreCase()
												.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		Example<Pessoa> example = Example.of(find, matcher);
		List<Pessoa> lista = pessoaRepository.findAll(example);
		return ResponseEntity.ok().body(lista);
	}
	
	
}
