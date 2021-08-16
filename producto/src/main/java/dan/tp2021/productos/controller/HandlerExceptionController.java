package dan.tp2021.productos.controller;

import dan.tp2021.productos.domain.dto.ErrorDTO;
import dan.tp2021.productos.exception.ProductoNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ProductoNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(ProductoNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

}
