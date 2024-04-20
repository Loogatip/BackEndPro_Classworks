package app.service;

import app.domain.User;
import app.repository.UserRepository;

public class UserServiceImpl implements UserService{

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getById(Long id) {
        // здесь идут различные проверки и бизнес-логика
        // например, идет проверка его заказов, что бы рассчитать для него скидку
        return repository.getById(id);
    }

    @Override
    public User save(User user) {
        // здесь идут различные проверки и бизнес-логика
        // Здесь мы можем отправить ему на емайл какую-либо вступительную акцию.
        return repository.save(user);
    }
}
