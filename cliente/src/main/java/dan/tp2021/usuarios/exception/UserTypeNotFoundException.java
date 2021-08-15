package dan.tp2021.usuarios.exception;

import dan.tp2021.usuarios.domain.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class UserTypeNotFoundException extends ClienteException {

    public UserTypeNotFoundException() {
        super(new ErrorDTO("Error Usuario", "El usuario debe tener un Tipo de Usuario asignado"), HttpStatus.BAD_REQUEST);
    }
}
