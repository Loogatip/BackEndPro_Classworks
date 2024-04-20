package client;

import app.controller.ProductController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Client {
    public static void main(String[] args) {

        // еще один вариант SPRING с прошлого урока

        AbstractApplicationContext context = new AnnotationConfigApplicationContext("app");
        ProductController controller = context.getBean(ProductController.class);
    //    System.out.println(controller.getById(1L));
        System.out.println(controller.getById(2L));
    //    System.out.println(controller.getById(3L));
    }
}
