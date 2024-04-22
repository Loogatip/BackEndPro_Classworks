package app.controller;

import app.model.Car;
import app.model.CarRepository;
import app.model.CarRepositoryMap;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Proba extends HttpServlet {

    private CarRepository repository = new CarRepositoryMap();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameters = req.getParameterMap();
        Long id = Long.parseLong(parameters.get("id")[0]);
        resp.getWriter().write(repository.getById(id).toString());
    }
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Allow", "GET, POST, PUT, DELETE, OPTIONS");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}