package dan.tp2021.usuarios.exception;

import dan.tp2021.usuarios.domain.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class ClienteCannotDeleteException extends ClienteException {

    public ClienteCannotDeleteException(){
        super(new ErrorDTO("Error Cliente", "El cliente no se puede eliminar ya que ha realizado pedidos"), HttpStatus.BAD_REQUEST);
    }
}
