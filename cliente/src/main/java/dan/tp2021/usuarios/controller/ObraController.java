package dan.tp2021.usuarios.controller;

import dan.tp2021.usuarios.domain.Obra;
import dan.tp2021.usuarios.exception.ClienteNotFoundException;
import dan.tp2021.usuarios.exception.ObraIncompletException;
import dan.tp2021.usuarios.exception.ObraNotFoundException;
import dan.tp2021.usuarios.exception.TipoObraNotFoundException;
import dan.tp2021.usuarios.service.obra.IObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/obra")
public class ObraController {

    @Autowired
    IObraService iObraService;

    @PostMapping("/crear")
    public ResponseEntity<Obra> crear(@RequestParam Obra obra) throws ObraIncompletException, ObraNotFoundException {
        return new ResponseEntity<>(iObraService.crear(obra), HttpStatus.OK);
    }

    @PutMapping("/update")
    public  ResponseEntity<Obra> update(@RequestParam Obra obra) throws ObraIncompletException, ObraNotFoundException {
        return new ResponseEntity<>(iObraService.update(obra), HttpStatus.OK);
    }

    @GetMapping("/getObras/{id}")
    public ResponseEntity<List<Obra>> getObras(
            @RequestParam int clienteCode,
            @RequestParam (required = false) int tipoObraCode) throws ClienteNotFoundException, TipoObraNotFoundException {
        return new ResponseEntity<>(iObraService.getObras(clienteCode, tipoObraCode), HttpStatus.OK);
    }

}
