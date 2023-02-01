package com.attornatus.procuradoriaDigital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attornatus.procuradoriaDigital.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
