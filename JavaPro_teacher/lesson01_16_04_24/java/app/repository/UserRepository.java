package app.repository;

import app.domain.User;

import java.util.List;

public interface UserRepository {

    // CRUD - Create, Read, Update, Delete

    User save(User user);

    User getById(Long id);

    List<User> getAll();

    User update(User user);

    void deleteById(Long id);
}