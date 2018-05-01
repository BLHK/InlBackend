package se.sero.project.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import se.sero.project.data.Todo;

import java.util.Optional;
import java.util.stream.Stream;

public interface TodoRepository {

    Todo add(Todo todo);

    Optional<Todo> get(Long id);

    Stream<Todo> getAll(Long id);


}
