package de.aittr.g_37_jp_shop.controller;

import de.aittr.g_37_jp_shop.domain.dto.ProductDto;
import de.aittr.g_37_jp_shop.domain.entity.Product;
import de.aittr.g_37_jp_shop.exception_handling.Response;
import de.aittr.g_37_jp_shop.exception_handling.exceptions.FirstTestException;
import de.aittr.g_37_jp_shop.service.interfaces.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // 1 способ запроса
    // GET - localhost:8080/products/example/5
//    @GetMapping("/example/{id}")   // -> (...) так не правильно, просто пример
//    public Product getById(@PathVariable Long id){
//        return service.getById(id);
//    }

    // 2 способ запроса
    // GET - localhost:8080/products/example?id=5
    //@GetMapping("/example")   // -> (...) так не правильно, просто пример

    // Обращаться к одному конкретному продукту
    // может любой пользователь (но зарегестрированный)
    @GetMapping
    public ProductDto getById(@RequestParam Long id){
//        if (id < 1) {
//            throw new FirstTestException("ID is incorrect!");
//        }

        return service.getById(id);
    }

    // GET - localhost:8080/products/all

    // просматривать все продукты могут все пользователи,
    // даже не зарегестрированные
    @GetMapping("/all")
    public List<ProductDto> getAll(){
        return service.getAll();
    }

    // Сохранять новый продукт в БД может только администратор.
    @PostMapping
    public ProductDto save(@RequestBody ProductDto product){
        return service.save(product);
    }

    // дополнительно прописано для FirsTestException
    @ExceptionHandler(FirstTestException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public Response handleException(FirstTestException e){
        System.out.println("Error! " + e.getMessage());  // -> это сообщение только в консоле
         e.printStackTrace();  // -> что бы в консоле дополнительно выводило всю инфу об ошибке
        return new Response(e.getMessage());
    }

}
