package dao;

import java.util.List;


import Classes.Cliente;
import interfaces.CRUD;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDao implements CRUD<Cliente>{
	private static List<Cliente> clientes = new ArrayList<>();
	
	
	public static List<Cliente> getAlla(){
		return clientes;
	}

	@Override
	public Cliente salvar(Cliente obj) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "insert into clientes(nome, email)VALUES(?,?)";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getNome());
			stm.setString(2, obj.getEmail());
			stm.execute();
			return obj;
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Cliente update(Cliente obj) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "update clientes set nome=?, email=? where id = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getNome());
			stm.setString(2, obj.getEmail());
			stm.setInt(3, obj.getId());
			stm.execute();
			
			return obj;
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		try {
			String sql = "delete from clientes WHERE id = ?";
			PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql);
			stm.setInt(1,id);
			stm.execute();
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Override
	public Cliente getById(int id) {
		 try{
			Cliente cliente = new Cliente();
	    	String sql = "select * from clientes where id = ?";
	    	PreparedStatement stm = DBConnection.getConnection().prepareStatement(sql);
	    	stm.setInt(1, id);
	    	ResultSet rs = stm.executeQuery();
	    	if(rs.next()) {
	    		cliente.setId(rs.getInt("id"));
	    		cliente.setNome(rs.getString("nome"));
	    		cliente.setEmail(rs.getString("email"));	    		
	    	}
	    	return cliente;
	    }catch(Exception e) {
	    	throw new RuntimeException(e.getMessage());
	    }		
	}

	@Override
	public List<Cliente> getAll() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			Connection con = DBConnection.getConnection();
			String sql = "Select id, nome, email FROM clientes";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				clientes.add(new Cliente(
						rs.getInt("id"),
						rs.getString("nome"),
						rs.getString("email"))
						);	
	        }
	        rs.close();
	        stm.close();
	        con.close();
	        return clientes;
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}