package app.controller;

import app.model.Car;
import app.model.CarRepository;
import app.model.CarRepositoryDB;
import app.model.CarRepositoryHibernate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CarServlet extends HttpServlet {

    private CarRepository repository = new CarRepositoryHibernate();

    private HashMap<String, Object> parseRequestBodyToHashMap(HttpServletRequest req) {
        try {
            BufferedReader reader = req.getReader();
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            ObjectMapper mapper = new ObjectMapper();
            HashMap<String, Object> jsonBodyHashMap = mapper.readValue(stringBuilder.toString(), HashMap.class);
            return jsonBodyHashMap;
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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

        HashMap<String, Object> requestJson = parseRequestBodyToHashMap(req);
        String brand = requestJson.get("brand").toString();
        BigDecimal price = new BigDecimal(requestJson.get("price").toString());
        int year = Integer.parseInt(requestJson.get("year").toString());

        Car car = new Car();
        car.setBrand(brand);
        car.setPrice(price);
        car.setYear(year);

        Long newCarId = repository.save(car).getId();
        resp.getWriter().write(repository.getById(newCarId) + " saved successfully!");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HashMap<String, Object> requestJson = parseRequestBodyToHashMap(req);
        Long id = Long.parseLong(requestJson.get("id").toString());
        BigDecimal newPrice = new BigDecimal(requestJson.get("price").toString());


        Car car = repository.getById(id);
        car.setPrice(newPrice);

        repository.update(car);
        resp.getWriter().write(repository.getById(id) + " price updated successfully!");
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> parameters = req.getParameterMap();
        Long id = Long.parseLong(parameters.get("id")[0]);

        repository.delete(id);

        resp.getWriter().write("Car deleted successfully!");
    }
}
