package dan.tp2021.usuarios.exception;

import dan.tp2021.usuarios.domain.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class ClienteNotFoundException extends ClienteException {

    public ClienteNotFoundException(){
        super(new ErrorDTO("Error Cliente", "El cliente no existe "), HttpStatus.BAD_REQUEST);
    }
}
