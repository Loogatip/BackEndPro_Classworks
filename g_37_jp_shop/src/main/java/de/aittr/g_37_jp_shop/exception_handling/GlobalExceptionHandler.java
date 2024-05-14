package de.aittr.g_37_jp_shop.exception_handling;

import de.aittr.g_37_jp_shop.exception_handling.exceptions.FourthTestException;
import de.aittr.g_37_jp_shop.exception_handling.exceptions.ProductNotFoundException;
import de.aittr.g_37_jp_shop.exception_handling.exceptions.ThirdTestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ThirdTestException.class)
    public ResponseEntity<Response> handleException(ThirdTestException e){
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
    }
    @ExceptionHandler(FourthTestException.class)
    public ResponseEntity<Response> handleException(FourthTestException e){
        Response response = new Response(e.getMessage(), e.getCause().getMessage());
        return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Response> handleException(ProductNotFoundException e){
        Response response = new Response(e.getMessage(), e.getCause().getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
