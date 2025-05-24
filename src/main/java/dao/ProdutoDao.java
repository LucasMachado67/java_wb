package dao;

import java.util.ArrayList;
import java.util.List;

import Classes.Produto;

public class ProdutoDao {
	
	private static List<Produto> produtos = new ArrayList<>();
	
	public static void insertProduct(Produto produto) {
		produto.setCode(produtos.size()+1);
		produtos.add(produto);
	}
	
	public static List<Produto> getAll(){
		return produtos;
	}
}
