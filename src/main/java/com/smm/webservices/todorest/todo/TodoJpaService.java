package com.smm.webservices.todorest.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoJpaService {
	@Autowired 
	private TodoJpaRepoository repository;
	
	public Todo findFirstByUsernameAndId(String username, Integer id) {
		return repository.findFirstByUsernameAndId(username, id).orElse(null);
	}
	public List<Todo> findByUsername(String username) {
		return repository.findByUsername(username).orElse(null);
	}
	public boolean deleteByUsernameAndId(String username, Integer id) {
		//better approach to use exceptions
		if(findFirstByUsernameAndId(username, id)!=null) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Todo updateTodo(String username, Todo todo) {
		//better approach to use exceptions
		Todo exisitingTodo = findFirstByUsernameAndId(username, todo.getId());
		if(exisitingTodo!=null) {
			exisitingTodo.setDone(todo.getDone());
			exisitingTodo.setTargetDate(todo.getTargetDate());
			exisitingTodo.setDescription(todo.getDescription());
			return repository.save(exisitingTodo);
		}
		return null;
	}
	
	public Todo createTodo(String username, Todo todo) {
		Todo exisitingTodo = findFirstByUsernameAndId(username, todo.getId());
		if(exisitingTodo==null)
			return repository.save(todo);
		return null;
	}
}
