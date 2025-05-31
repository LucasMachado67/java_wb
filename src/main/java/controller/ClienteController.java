package controller;

import Classes.Cliente;
import dao.ClienteDao;

public class ClienteController {
	
	
	public Cliente salvar(Cliente cliente) {
		try {
			//Validating
			return new ClienteDao().salvar(cliente);
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public Cliente update(Cliente cliente) {
		try {
		  return new ClienteDao().update(cliente);			
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void delete(Cliente cliente) {
		try {
			new ClienteDao().delete(cliente.getId());
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}
}
