package app.model;

import jakarta.persistence.EntityManager;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CarRepositoryHibernate implements CarRepository{

    private EntityManager entityManager;

    public CarRepositoryHibernate() {
        this.entityManager = new Configuration()
                .configure("postgres.cfg.xml")
                .buildSessionFactory()
                .createEntityManager();
    }

    @Override
    public Car save(Car car) {
        entityManager.getTransaction().begin();
        entityManager.persist(car);
        entityManager.getTransaction().commit();
        return car;
    }

    @Override
    public Car getById(Long id) {
        entityManager.getTransaction().begin();
        Car car = entityManager.find(Car.class, id);
        entityManager.getTransaction().commit();
        return car;
    }

    @Override
    public List<Car> getAll() {
        entityManager.getTransaction().begin();
        List<Car> cars = entityManager.createQuery("from Car").getResultList();
        entityManager.getTransaction().commit();
        return cars;
    }

    @Override
    public void update(Car car) {
        entityManager.getTransaction().begin();
        entityManager.merge(car);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();
        Car car = entityManager.find(Car.class, id);
        entityManager.remove(car);
        entityManager.getTransaction().commit();
    }
}
