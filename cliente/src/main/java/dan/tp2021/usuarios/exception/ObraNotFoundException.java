package dan.tp2021.usuarios.exception;

import dan.tp2021.usuarios.domain.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class ObraNotFoundException extends ObraException{

    public ObraNotFoundException(){
        super(new ErrorDTO("Obra Not Found", "Id could not be found "), HttpStatus.BAD_REQUEST);
    }
}
