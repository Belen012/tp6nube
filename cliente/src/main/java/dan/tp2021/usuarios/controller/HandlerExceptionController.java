package dan.tp2021.usuarios.controller;

import dan.tp2021.usuarios.domain.TipoObra;
import dan.tp2021.usuarios.domain.dto.ErrorDTO;
import dan.tp2021.usuarios.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerExceptionController {
    @ExceptionHandler(ClienteCannotDeleteException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(ClienteCannotDeleteException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(ClienteCannotSearchedException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(ClienteCannotSearchedException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(ClienteDateInvalidException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(ClienteDateInvalidException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(ClienteNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(ObraIncompletException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(ObraIncompletException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(ObraNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(ObraNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(TipoObraNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(TipoObraNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(UserNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(UserTypeException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(UserTypeException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(UserTypeNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(UserTypeNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

}
