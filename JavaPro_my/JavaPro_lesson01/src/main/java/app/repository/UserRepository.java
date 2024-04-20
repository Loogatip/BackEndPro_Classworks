package app.repository;

import app.domain.User;

import java.util.List;

public interface UserRepository {

    // CRUD - Create, Read, Update, Delete

    // Create
    User save(User user);

    // Read
    User getById(Long id);
    List<User> getAll();

    // Update
    User update(User user);

    // Delete
    void deleteById(Long id);
}
