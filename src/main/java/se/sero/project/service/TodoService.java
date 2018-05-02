package se.sero.project.service;

import org.springframework.stereotype.Service;
import se.sero.project.data.Todo;
import se.sero.project.repository.TodoRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class TodoService {

    private final TodoRepository repository;
    private static final AtomicLong ids = new AtomicLong(1000);


    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo createTodo(Todo todo){
        return repository.add(new Todo(ids.incrementAndGet(), todo.getToDo(),todo.getPriority(),todo.getUser()));
    }


    public Optional<Todo> getTodo(Long id){
        return repository.get(id);
    }


    public List<Todo> getAll() {
        return repository.getAll().collect(toList());
    }


    public Optional<Todo> deleteTodo(Long id) {
        return repository.delete(id);
    }


}
