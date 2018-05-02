package se.sero.project.repository.memory;

import org.springframework.stereotype.Repository;
import se.sero.project.data.Todo;
import se.sero.project.repository.TodoRepository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@Repository
public class InMemoryTodoRepository implements TodoRepository {

    private final Map<Long, Todo> todos = new ConcurrentHashMap<>();


    @Override
    public Todo add(Todo todo) {
        todos.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public Optional<Todo> get(Long id) {
        return Optional.ofNullable(todos.get(id));
    }


    @Override
    public Stream<Todo> getAll() {
        return todos.values().stream();
    }

    @Override
    public Optional<Todo> delete(Long id) {
        return Optional.ofNullable(todos.remove(id));
    }
}
