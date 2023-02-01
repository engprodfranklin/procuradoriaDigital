package com.attornatus.procuradoriaDigital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.procuradoriaDigital.entities.Endereco;
import com.attornatus.procuradoriaDigital.repositories.EnderecoRepository;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	//Find all list
	@GetMapping
	public ResponseEntity<List<Endereco>> findAll() {
		List<Endereco> lista = enderecoRepository.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	//Find By Id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Integer id) {
		if (enderecoRepository.existsById(id)) {
			Endereco resultado = enderecoRepository.findById(id).get();
			return ResponseEntity.ok().body(resultado);
		}
		return ResponseEntity.notFound().build();
	}
	
	//Save information with RequestBody
	@PostMapping
	public ResponseEntity<Endereco> created(@RequestBody Endereco endereco) {
		Endereco resultado = enderecoRepository.save(endereco);
		return ResponseEntity.ok().body(resultado);
	}
	
	//Update
	@PutMapping
	public ResponseEntity<Endereco> update(@RequestBody Endereco endereco) {
		Endereco atualizacao = enderecoRepository.save(endereco);
		return ResponseEntity.ok().body(atualizacao);
	}

	//Delete adress
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Integer id) {
		if (enderecoRepository.existsById(id)) {
			enderecoRepository.deleteById(id);
		}
	}
}
