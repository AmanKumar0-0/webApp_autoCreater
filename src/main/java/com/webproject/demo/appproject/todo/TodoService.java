package com.webproject.demo.appproject.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
	public static List<Todo> todos = new ArrayList<>();
	 private static int todoCount = 0;
	 
	 // Initializing the static block 
	 static {
		 todos.add(new Todo(++todoCount,"Aman","Learn AWS",LocalDate.now().plusYears(1),false));
		 todos.add(new Todo(++todoCount, "Aman", "Learn Linux", LocalDate.now().plusYears(1), false));
		 todos.add(new Todo(++todoCount, "Aman", "Learn Assembly", LocalDate.now().plusMonths(6), false));
		 todos.add(new Todo(++todoCount, "Aman", "Learn DevOps", LocalDate.now().plusMonths(6), false));
	 }
	 
	 public List<Todo> findByUsername(String username){
		 Predicate<? super Todo> predicate = todoCount -> todoCount.getUsername().equalsIgnoreCase(username);
		 return todos.stream().filter(predicate).toList();
	 }
	 
	 public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		 Todo todo = new Todo(++todoCount,username, description, targetDate, done);
		 todos.add(todo);
	 }
	 
	 public void deleteById(int id) {
		 Predicate<? super Todo> predicate = todoCount -> todoCount.getId() == id ;
		 todos.removeIf(predicate);
	 }
	 
	 public Todo findById(int id) {
		 Predicate<? super Todo> predicate = todoCount -> todoCount.getId() == id ;	
		 Todo todo = todos.stream().filter(predicate).findFirst().get();
		 return todo;
	}

	 public void updateTodo(@Valid Todo todo) {
		 deleteById(todo.getId());
		 todos.add(todo);
	 }

}
