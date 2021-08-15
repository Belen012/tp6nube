package dan.tp2021.usuarios.exception;

import dan.tp2021.usuarios.domain.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class TipoObraNotFoundException extends ClienteException {

    public TipoObraNotFoundException(){
        super(new ErrorDTO("Error Tipo Obra", "El tipo de obra no existe"), HttpStatus.BAD_REQUEST);
    }
}
