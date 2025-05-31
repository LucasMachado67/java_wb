package interfaces;

import java.util.List;

public interface CRUD <T>{
	//Creating a generic method so every class can use this method
	//So we don't need to make one method to Client and other to Product
	T salvar(T obj);
	
	T update(T obj);
	
	void delete(int id);
	
	T getById(int id);
	
	List<T> getAll();
}
