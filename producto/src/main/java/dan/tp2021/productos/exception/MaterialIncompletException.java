package dan.tp2021.productos.exception;

import dan.tp2021.productos.domain.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class MaterialIncompletException extends ProductoException {

    public MaterialIncompletException(){
        super(new ErrorDTO("Error Producto", "El producto no puede tener campos vacios "), HttpStatus.BAD_REQUEST);
    }
}
