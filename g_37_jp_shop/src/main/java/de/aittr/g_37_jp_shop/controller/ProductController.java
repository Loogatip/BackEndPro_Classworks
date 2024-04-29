package de.aittr.g_37_jp_shop.controller;

import de.aittr.g_37_jp_shop.domain.entity.Product;
import de.aittr.g_37_jp_shop.service.interfaces.ProductService;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/example")   // -> (...) так не правильно, просто пример
    public Product getById(@RequestParam Long id){
        return service.getById(id);
    }
}