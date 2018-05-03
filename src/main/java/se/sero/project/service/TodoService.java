package se.sero.project.service;

import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.stereotype.Service;
import se.sero.project.data.Todo;
import se.sero.project.repository.TodoRepository;
import se.sero.project.service.exceptions.InvalidTodoException;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo createTodo(Todo todo){
        validate(todo);
        return repository.save(new Todo(todo.getUser(), todo.getToDo(), todo.getPriority()));
    }

    public Optional<Todo> getTodo(Long id){
        return repository.findById(id);
    }

    public List<Todo> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    public boolean deleteTodo(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Todo> getTodosByUserId(Long userId) {

        return Lists.newArrayList(repository.getTodosByUser_Id(userId));
    }

    public List<Todo> getTodosByUserIdAndPriority(Long id, String priority) {
        return Lists.newArrayList(repository.getTodosByUser_IdAndPriority(id, priority));
    }

    private void validate(Todo todo) {
        if (todo.getToDo() == null || todo.getToDo().isEmpty() ||
                todo.getPriority() == null || todo.getPriority().isEmpty()) {
            throw new InvalidTodoException("Fields of object Todo cannot be empty.");
        }
    }

}
