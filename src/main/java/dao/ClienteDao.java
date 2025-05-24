package dao;

import java.util.List;

import Classes.Cliente;

import java.util.ArrayList;

public class ClienteDao {
	private static List<Cliente> clientes = new ArrayList<>();
	
	public static void insert(Cliente cliente) {
		cliente.setId(clientes.size() + 1);
		clientes.add(cliente);
	}
	
	public static List<Cliente> getAll(){
		return clientes;
	}
	
	
}
