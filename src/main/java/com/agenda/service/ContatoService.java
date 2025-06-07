package com.agenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.models.Contato;
import com.agenda.repository.ContatoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContatoService {
	
	
	@Autowired
	private ContatoRepository repository;
	
	public Contato save(Contato contato) {
		return repository.save(contato);
	}
	
	public Contato getById(long id) {
		Contato contato = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		return contato;
	}
	
	public List<Contato> getAll(){
		return repository.findAll();
	}
	
	public Object update(Contato contato) {
		var contatoToEdit = repository.findById(contato.getId())
				.orElseThrow(() -> new RuntimeException("Contato with id: " + contato.getId() + "not found"));
		contatoToEdit.setNome(contato.getNome());
		contatoToEdit.setEmail(contato.getEmail());
		return repository.save(contatoToEdit);
	}
	
	public void delete(long id) {
        if(id < 0){
            throw new IllegalArgumentException("Invalid Id");
        }
        repository.deleteById(id);
        
    }
	
	
}
