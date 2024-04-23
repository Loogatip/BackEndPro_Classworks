package app.model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static app.constants.Constants.*;

public class CarRepositoryDB implements CarRepository {

    private Connection getConnection(){
        try {
            Class.forName(DB_DRIVER_PATH);
            String dbUrl = String.format("%s%s?user=%s&password=%s",
                    DB_ADDRESS,DB_NAME, DB_USERNAME, DB_PASSWORD);
            return DriverManager.getConnection(dbUrl);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Car save(Car car) {
        try (Connection connection = getConnection()){

            String query = String.format("INSERT INTO car (brand, price, year) VALUES ('%s', %s, %d)",
                    car.getBrand(), car.getPrice(), car.getYear());
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                long id = resultSet.getLong(1);
                car.setId(id);
            }
            return car;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Car getById(Long id) {
        try (Connection connection = getConnection()){

            String query = String.format("SELECT * FROM car WHERE id = %d", id);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();   // для  getAll в цикле while (resultSet.next())
            String brand = resultSet.getString(2); // -> или номер колонки (2)
            BigDecimal price = resultSet.getBigDecimal(3);
            int year = resultSet.getInt(4);

            return  new Car(id, brand, price, year);

        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Car> getAll() {

        List<Car> cars = new ArrayList<>();
        try (Connection connection = getConnection()){
            String query = String.format("SELECT * FROM car");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String brand = resultSet.getString(2);
                BigDecimal price = resultSet.getBigDecimal(3);
                int year = resultSet.getInt(4);
                cars.add(new Car(id, brand, price, year));
            }

        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return cars;
    }

    @Override
    public void update(Car car) {
        try (Connection connection = getConnection()){

            String query = String.format("UPDATE car SET price = %s WHERE id = %d",
                    car.getPrice(),car.getId());
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = getConnection()){
            String query = String.format("DELETE FROM car WHERE id = %d", id);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
