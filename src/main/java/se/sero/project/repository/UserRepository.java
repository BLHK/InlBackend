package se.sero.project.repository;


import org.springframework.data.repository.CrudRepository;
import se.sero.project.data.User;

import java.util.List;
import java.util.stream.Stream;


public interface UserRepository extends CrudRepository<User, Long> {


    //Stream<User> getAll();

    //List<User> findByFirstName(String firstName);
    /*
    User add(User user);

    Optional<User> get(Long id);

    Stream<User> getAll(int limit);

    User update(User user);

    Optional<User> delete(Long id);
    */


}
