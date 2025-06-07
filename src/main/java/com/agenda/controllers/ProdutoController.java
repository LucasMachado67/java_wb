package com.agenda.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.agenda.models.Produto;
import com.agenda.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	
	
	@Autowired
	private ProdutoService service;
	
	
	@GetMapping()
	public ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable("id") int id) {
		
		try {
			return ResponseEntity.ok(service.getById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Produto> insert(@RequestBody Produto produto) {
		try {
			return ResponseEntity.ok(service.save(produto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestBody Produto produto, @PathVariable("id") int id){
		
		try {
			List<Produto> produtos = service.getAll();
			for(Produto ct : produtos) {
				if(id == ct.getId()) {
					return ResponseEntity.ok(service.update(produto));
				}
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") int id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
