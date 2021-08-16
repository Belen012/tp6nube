package dan.tp2021.productos.exception;

import dan.tp2021.productos.domain.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class ProductoCannotSearchedException extends ProductoException {

    public ProductoCannotSearchedException(){
        super(new ErrorDTO("Error Producto", "No se puede buscar el producto "), HttpStatus.BAD_REQUEST);
    }
}
