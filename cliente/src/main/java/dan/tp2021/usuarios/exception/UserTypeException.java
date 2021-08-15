package dan.tp2021.usuarios.exception;

import dan.tp2021.usuarios.domain.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class UserTypeException extends ClienteException {

    public UserTypeException(){
        super(new ErrorDTO("Error Cliente", "No se puede dar de alta al cliente, la situacion crediticia debe ser Tipo 1 o Tipo 2"), HttpStatus.BAD_REQUEST);
    }
}
