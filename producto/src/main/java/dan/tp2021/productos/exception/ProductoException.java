package dan.tp2021.productos.exception;


import dan.tp2021.productos.domain.dto.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoException extends Exception{

    private ErrorDTO error;
    private HttpStatus status;
}
