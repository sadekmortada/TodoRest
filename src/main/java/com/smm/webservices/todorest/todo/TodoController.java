package com.smm.webservices.todorest.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{username}/todos")
@CrossOrigin(origins = "http://localhost:3000/")
public class TodoController {

	@Autowired
	private TodoJpaService todoService;
	@GetMapping
	public ResponseEntity<List<Todo>> getAllTodos(@PathVariable String username){
		return ResponseEntity.ofNullable(todoService.findByUsername(username));
	}
	@GetMapping("/{todoId}")
	public ResponseEntity<Todo> getTodoById(@PathVariable String username, @PathVariable Integer todoId){
		return ResponseEntity.ofNullable(todoService.findFirstByUsernameAndId(username,todoId));
	}
	@DeleteMapping("/{todoId}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Integer todoId){
		if(todoService.deleteByUsernameAndId(username, todoId)) 
			return ResponseEntity.noContent().build();
		return ResponseEntity.notFound().build();
	}
	@PostMapping
	public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo){
		return ResponseEntity.ofNullable(todoService.createTodo(username, todo));
	}
	@PutMapping
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @RequestBody Todo todo){
		return ResponseEntity.ofNullable(todoService.updateTodo(username,todo));
	}
}
