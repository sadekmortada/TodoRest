package com.smm.webservices.todorest.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoJpaRepoository extends JpaRepository<Todo,Integer> {
	public Optional<List<Todo>> findByUsername(String username);
	public Optional<Todo> findFirstByUsernameAndId(String username, Integer id);
}
