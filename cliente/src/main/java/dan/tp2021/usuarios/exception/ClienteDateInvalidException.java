package dan.tp2021.usuarios.exception;

import dan.tp2021.usuarios.domain.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class ClienteDateInvalidException extends ClienteException {

    public ClienteDateInvalidException(){
        super(new ErrorDTO("Error Cliente", "No se puede mostrar el cliente ya que registra pedidos"), HttpStatus.BAD_REQUEST);
    }
}

