package se.sero.project.repository.memory;

import org.springframework.stereotype.Repository;
import se.sero.project.data.User;
import se.sero.project.repository.UserRepository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@Repository
public class InMemoryUserRepository implements UserRepository {

    private final Map<Long, User> users = new ConcurrentHashMap<>();


    @Override
    public User add(User user) {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> get(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public Stream<User> getAll(int limit) {
        return users.values().stream().limit(limit);
    }

    @Override
    public User update(User user) {
        if(users.containsKey(user.getId())){
            users.put(user.getId(), user);
        }
        return user;
    }

    @Override
    public Optional<User> delete(Long id) {
        return Optional.ofNullable(users.remove(id));
    }
}
