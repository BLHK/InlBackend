package se.sero.project.service;

import org.springframework.stereotype.Service;
import se.sero.project.data.Todo;
import se.sero.project.repository.TodoRepository;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

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




    /*

    public Optional<User> getUser(Long id){
        return repository.get(id);
    }

    public User updateUser(User user){
        return repository.update(user);
    }

    public Optional<User> deleteUser(Long id){
        return repository.delete(id);
    }

    public List<User> getAllUsers(int limit) {
        return repository.getAll(limit).collect(toList());
    }

     */



}
