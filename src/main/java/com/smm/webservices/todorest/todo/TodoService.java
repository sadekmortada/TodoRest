package com.smm.webservices.todorest.todo;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
//	private Logger logger = LoggerFactory.getLogger(getClass());
	private static List<Todo> todos;
	static {
		todos = new LinkedList<Todo>(Arrays.asList(
				new Todo(1, "sadek", "sleep", LocalDate.now(), false),
				new Todo(2, "sadek", "brush before sleep hehe", LocalDate.now(), false),
				new Todo(3, "mahdi", "finish my angular internship", LocalDate.now().minusMonths(2), true),
				new Todo(4, "sadek", "finish my web app freelance", LocalDate.now().plusDays(7), false),
				new Todo(5, "ali", "finish Ranga course", LocalDate.now().plusDays(10), false)));
	}

	public List<Todo> findByUserName(String username) {
		Predicate<? super Todo> predicate = todo->todo.getUsername().equals(username);
		return todos.stream().filter(predicate).toList();
	}

	public Todo findById(String username, int id) {
		Predicate<? super Todo> predicate = todo->todo.getUsername().equals(username)&&todo.getId()==id;
		return todos.stream().filter(predicate).findFirst().orElse(null);
	}

	public Todo addNewTodo(Todo todo) {
		if (todos.size() > 0)
			todo.setId(todos.get(todos.size() - 1).getId() + 1);
		todos.add(todo);
		return todo;
	}

	public Todo updateTodo(String username, Todo todo) {
		Predicate<? super Todo> predicate = listTodo->listTodo.getUsername().equals(username)&&listTodo.getId()==todo.getId();
		Todo oldTodo = todos.stream().filter(predicate).findFirst().get();
		oldTodo.setDescription(todo.getDescription());
		oldTodo.setDone(todo.getDone());
		oldTodo.setTargetDate(todo.getTargetDate());
		return oldTodo;
	}

	public void deleteTodo(String username, int id) {
		Predicate<? super Todo> predicate = todo->todo.getUsername().equals(username)&&todo.getId()==id;
		todos.removeIf(predicate);
	}

	public int deleteById(int id) {
		int count;
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		count = (int) todos.stream().filter(predicate).count();
		todos.removeIf(predicate);
		return count;
	}
}
