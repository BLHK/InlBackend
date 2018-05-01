package se.sero.project.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import se.sero.project.data.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface UserRepository{

    //List<User> findByFirstName(String firstName);

    User add(User user);

    Optional<User> get(Long id);

    Stream<User> getAll(int limit);

    User update(User user);

    Optional<User> delete(Long id);



}
