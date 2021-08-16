package dan.tp2021.productos.exception;

import dan.tp2021.productos.domain.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class ProductoNotFoundException extends ProductoException {

    public ProductoNotFoundException(){
        super(new ErrorDTO("Error Producto", "El producto no existe "), HttpStatus.BAD_REQUEST);
    }
}
