package dan.tp2021.usuarios.exception;

import dan.tp2021.usuarios.domain.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class UserNotFoundException  extends ClienteException {

    public UserNotFoundException(){
        super(new ErrorDTO("Error Usuario", "El Usuario no puede ser vacio"), HttpStatus.BAD_REQUEST);
    }
}
