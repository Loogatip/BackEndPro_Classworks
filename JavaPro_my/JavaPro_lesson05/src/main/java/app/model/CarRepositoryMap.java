package app.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CarRepositoryMap implements CarRepository {

    private Map<Long, Car> database = new HashMap<>();
    private long currentId;

    public CarRepositoryMap() {
        save(new Car("VW", new BigDecimal(10000), 2010));
        save(new Car("Mazda", new BigDecimal(30000), 2015));
        save(new Car("VHonda", new BigDecimal(50000), 2020));
    }

    @Override
    public Car save(Car car) {
        car.setId(++currentId);
        database.put(currentId, car);
        return car;
    }
    @Override
    public Car getById(Long id) {
        return database.get(id);
    }
    @Override
    public List<Car> getAll() {
        return new ArrayList<>(database.values());
        // или через .stream
        // return database.values().stream().toList();
    }
    @Override
    public void update(Car car) {
        // database.put(car.getId(), car);      -> это не правильно
        Car foundCar = database.get(car.getId());
        if (foundCar != null){
            foundCar.setPrice(car.getPrice());
        }
    }
    @Override
    public void delete(Long id) {
        database.remove(id);
    }
}
