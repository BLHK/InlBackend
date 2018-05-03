package se.sero.project.repository;


import org.springframework.data.repository.CrudRepository;
import se.sero.project.data.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Stream;


public interface UserRepository extends CrudRepository<User, Long> {

}
