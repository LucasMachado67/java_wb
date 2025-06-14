package com.aula.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.modelos.Contato;
import com.aula.repositories.ContatoRepository;

@Service
public class ContatoDao {
	
	@Autowired
	private ContatoRepository repository;
	
	
	public void add(Contato contato) {
		repository.save(contato);
	}
	
	public List<Contato> getAll(){
		return repository.findAll();
	}
	
}
