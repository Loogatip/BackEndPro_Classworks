package app.controller;

import app.model.Car;
import app.model.CarRepository;
import app.model.CarRepositoryDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class CarServlet extends HttpServlet {

    private CarRepository repository = new CarRepositoryDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // запрос
        // http://255.255.255.15:8080/cars - наша задача получить идентификатор запроса
        Map<String, String[]> parameters = req.getParameterMap();
        if (parameters.get("id") != null) {
            Long id = Long.parseLong(parameters.get("id")[0]);
            // ответ
            resp.getWriter().write(repository.getById(id).toString());
        } else {
            resp.getWriter().write(repository.getAll().toString());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String brand = req.getParameter("brand");
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        int year = Integer.parseInt(req.getParameter("year"));

        Car car = new Car();
        car.setBrand(brand);
        car.setPrice(price);
        car.setYear(year);

        Long newCarId = repository.save(car).getId();

        resp.getWriter().write("Car " + repository.getById(newCarId) + "saved successfully!");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> parameters = req.getParameterMap();

        Long id = Long.parseLong(parameters.get("id")[0]);

        BigDecimal newPrice = new BigDecimal(parameters.get("price")[0]);

        Car car = repository.getById(id);

        car.setPrice(newPrice);

        repository.update(car);

        resp.getWriter().write("Car " + repository.getById(id) +" price updated successfully!");
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> parameters = req.getParameterMap();
        Long id = Long.parseLong(parameters.get("id")[0]);

        repository.delete(id);

        resp.getWriter().write("Car deleted successfully!");
    }
}
