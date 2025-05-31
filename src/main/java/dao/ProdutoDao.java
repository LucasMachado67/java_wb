package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Classes.Produto;
import interfaces.CRUD;
import utils.DBConnection;

public class ProdutoDao implements CRUD<Produto>{
	
	private static List<Produto> produtos = new ArrayList<>();
	
	public static void insertProduct(Produto produto) {
		produto.setCode(produtos.size()+1);
		produtos.add(produto);
	}
	

	@Override
	public Produto salvar(Produto obj) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "insert into produtos(descricao, preco, unidadeMedida, estoque, categoria)VALUES(?,?,?,?,?)";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getDescricao());
			stm.setDouble(2, obj.getPreco());
			stm.setString(3, obj.getUnidadeMedida());
			stm.setInt(4, obj.getEstoque());
			stm.setString(5, obj.getCategoria());
			stm.execute();
			return obj;
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Produto update(Produto obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> getAll() {
		List<Produto> produtos = new ArrayList<>();
		try {
			Connection con = DBConnection.getConnection();
			String sql = "Select code, descricao, preco, unidadeMedida, estoque, categoria FROM produtos";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				Produto produto = new Produto();
				produto.setCode(rs.getInt("code"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setUnidadeMedida(rs.getString("unidadeMedida"));
				produto.setEstoque(rs.getInt("estoque"));
				produto.setCategoria(rs.getString("categoria"));
				produtos.add(produto);
	        }

	        rs.close();
	        stm.close();
	        con.close();
	        return produtos;
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
