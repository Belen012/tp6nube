package dan.tp2021.usuarios.exception;

import dan.tp2021.usuarios.domain.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class ObraIncompletException extends ClienteException {

    public ObraIncompletException() {
        super(new ErrorDTO("Error Obra", "No puede haber campus nulos"), HttpStatus.BAD_REQUEST);
    }
}
