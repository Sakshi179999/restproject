package org.example.restproject.controller;

import org.example.restproject.exception.ResourceNotFoundException;
import org.example.restproject.model.Todo;
import org.example.restproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.example.restproject.repository.UserRepository.*;

@RestController
@RequestMapping("api/v1/users")
public class taskcontroller {

    @Autowired
    private UserRepository userRepo;

    @GetMapping
    public List<Todo> getAllTodos() {

        return userRepo.findAll();
    }

  // build create todo rest api
    @PostMapping
    public Todo  createTodo(@RequestBody Todo todo) {

        return userRepo.save(todo);
    }

    // build get mapping by id
    @GetMapping("{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable long id) {
          Todo todo = userRepo.findById(id)
                  .orElseThrow(() -> new ResourceNotFoundException("Todo not found" +id));

          return ResponseEntity.ok(todo);

    }
//build update todo
    @PutMapping("{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable long id, @RequestBody Todo todo) {
        Todo updateTodo = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("todo not exists with id: "+id));

        updateTodo.setTask(todo.getTask());
        updateTodo.setCompleted(todo.isCompleted());
        userRepo.save(updateTodo);
        return ResponseEntity.ok(updateTodo);

    }
  // build  delete todo rest api
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable long id) {
        Todo todo = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("todo not exists with id: "+id));
        userRepo.delete(todo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }






}
