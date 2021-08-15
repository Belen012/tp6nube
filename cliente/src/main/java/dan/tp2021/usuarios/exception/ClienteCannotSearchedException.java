package dan.tp2021.usuarios.exception;

import dan.tp2021.usuarios.domain.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class ClienteCannotSearchedException extends ClienteException {

    public ClienteCannotSearchedException(){
        super(new ErrorDTO("Error Cliente", "No se puede buscar el cliente"), HttpStatus.BAD_REQUEST);
    }
}
