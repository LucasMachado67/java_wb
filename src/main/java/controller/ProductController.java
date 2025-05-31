package controller;

import java.util.List;

import Classes.Produto;
import dao.ProdutoDao;

public class ProductController {
	
	
	public Produto salvar(Produto produto) {
		try {
			
			return new ProdutoDao().salvar(produto);
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}
}
