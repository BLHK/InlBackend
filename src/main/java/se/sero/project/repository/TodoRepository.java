package se.sero.project.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import se.sero.project.data.Todo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    List<Todo> getTodosByUser_Id(Long id);

    List<Todo> getTodosByUser_IdAndPriority(Long id, String priority);
}
