package com.agenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.models.Produto;
import com.agenda.repository.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {
	
	
	@Autowired
	private ProdutoRepository repository;
	
	public Produto save(Produto produto) {
		return repository.save(produto);
	}
	
	public Produto getById(long id) {
		Produto produto = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		return produto;
	}
	
	public List<Produto> getAll(){
		return repository.findAll();
	}
	
	public Object update(Produto produto) {
		var produtoToEdit = repository.findById(produto.getId())
				.orElseThrow(() -> new RuntimeException("Contato with id: " + produto.getId() + "not found"));
		produtoToEdit.setDescricao(produto.getDescricao());
		produtoToEdit.setPreco(produto.getPreco());
		return repository.save(produtoToEdit);
	}
	
	public void delete(long id) {
        if(id < 0){
            throw new IllegalArgumentException("Invalid Id");
        }
        repository.deleteById(id);
	}
}
