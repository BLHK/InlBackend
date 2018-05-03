package se.sero.project.service;

import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.stereotype.Service;
import se.sero.project.data.User;
import se.sero.project.repository.UserRepository;
import se.sero.project.service.exceptions.InvalidUserException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.stream.Collectors.toList;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user){
        validate(user);
        return repository.save(new User(user.getFirstName(), user.getLastName()));
    }

    public Optional<User> getUser(Long id){
        return repository.findById(id);
    }

    public List<User> getAllUsers() {
        return Lists.newArrayList(repository.findAll());
    }

    public boolean deleteUser(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    private void validate(User user) {
        if (user.getFirstName() == null || user.getFirstName().isEmpty() ||
                user.getLastName() == null || user.getLastName().isEmpty()) {
            throw new InvalidUserException("Fields of object User cannot be empty.");
        }
    }
}
