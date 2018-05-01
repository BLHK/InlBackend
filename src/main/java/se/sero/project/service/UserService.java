package se.sero.project.service;

import org.springframework.stereotype.Service;
import se.sero.project.data.User;
import se.sero.project.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.stream.Collectors.toList;

@Service
public class UserService {

    private final UserRepository repository;
    private static final AtomicLong ids = new AtomicLong(1000);

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user){
        return repository.add(new User(ids.incrementAndGet(), user.getFirstName(),user.getLastName()));
    }

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




}
