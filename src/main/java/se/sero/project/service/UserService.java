package se.sero.project.service;

import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.stereotype.Service;
import se.sero.project.data.User;
import se.sero.project.repository.UserRepository;

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

    /*
    GJORD MEN BEHÖVS EJ :(

    public User updateUser (User user){
        if(repository.existsById(user.getId())){
            repository.save(user);
        }
        return user;
    }
    */
    /*
    public List<User> getAllUsers() {
        return repository.findAll(limit).collect(toList());
    }




    public User updateUser(User user){
        return repository.update(user);
    }

    public Optional<User> deleteUser(Long id){
        return repository.delete(id);
    }

    */



}
