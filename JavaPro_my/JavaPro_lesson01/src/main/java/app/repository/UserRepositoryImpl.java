package app.repository;

import app.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository{

    private Map<Long, User> database = new HashMap<>();
    private Long currentId = 0L;

    public UserRepositoryImpl() {
        save(new User("john@test.com","111"));
        save(new User("jack@test.com","222"));
        save(new User("nick@test.com","333"));
    }

    @Override
    public User save(User user) {
        user.setId(++currentId);
        database.put(currentId, user);
        return user;
    }

    @Override
    public User getById(Long id) {
        return database.get(id);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(database.values());
//        return database.values().stream().toList();
    }

    @Override
    public User update(User user) {
        database.put(user.getId(), user);
        return user;
    }

    @Override
    public void deleteById(Long id) {
        database.remove(id);
    }
}
