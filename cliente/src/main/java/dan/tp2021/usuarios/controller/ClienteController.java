package dan.tp2021.usuarios.controller;

import dan.tp2021.usuarios.domain.Cliente;
import dan.tp2021.usuarios.domain.dto.ClienteDTO;
import dan.tp2021.usuarios.exception.*;
import dan.tp2021.usuarios.service.cliente.IClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {


    //private static final List<Cliente> listaClientes = new ArrayList<>();
    //private static Integer ID_GEN = 1;

    @Autowired
    IClienteService iClienteService;

    @PostMapping("/crear")
    public ResponseEntity<Cliente> crear(@RequestBody ClienteDTO clienteDTO) throws ObraNotFoundException, UserTypeNotFoundException, UserTypeException, UserNotFoundException {
        return new ResponseEntity<>(iClienteService.crear(clienteDTO), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Cliente> update(@RequestBody ClienteDTO clienteDTO) throws ObraNotFoundException, ClienteNotFoundException, UserTypeNotFoundException, UserTypeException, UserNotFoundException {
        return new ResponseEntity<>(iClienteService.update(clienteDTO), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<HttpStatus> eliminar(@RequestParam int clienteCode) throws ClienteNotFoundException, ClienteCannotDeleteException {
        iClienteService.eliminar(clienteCode);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    //revisar
    @GetMapping("/obtenerCliente")
    public ResponseEntity<ClienteDTO> getCliente(
            @RequestParam(required = false) String cuit,
            @RequestParam(required = false) String razonSocial,
            @RequestParam(required = false) int obraCode) throws ClienteCannotSearchedException, ClienteNotFoundException, ClienteDateInvalidException {
        return new ResponseEntity<>(iClienteService.getCliente(cuit, razonSocial, obraCode), HttpStatus.OK);
    }




/*
    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Busca un cliente por id")
    public ResponseEntity<Cliente> clientePorId(@PathVariable Integer id){

        Optional<Cliente> c =  listaClientes
                .stream()
                .filter(unCli -> unCli.getId().equals(id))
                .findFirst();
        return ResponseEntity.of(c);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Cliente>> todos(){
        return ResponseEntity.ok(listaClientes);
    }


    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Actualiza un cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Actualizado correctamente"),
            @ApiResponse(code = 401, message = "No autorizado"),
            @ApiResponse(code = 403, message = "Prohibido"),
            @ApiResponse(code = 404, message = "El ID no existe")
    })
    public ResponseEntity<Cliente> actualizar(@RequestBody Cliente nuevo,  @PathVariable Integer id){
        OptionalInt indexOpt =   IntStream.range(0, listaClientes.size())
                .filter(i -> listaClientes.get(i).getId().equals(id))
                .findFirst();

        if(indexOpt.isPresent()){
            listaClientes.set(indexOpt.getAsInt(), nuevo);
            return ResponseEntity.ok(nuevo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}") //se tiene que comunicar con el microservicio de pedido
    public ResponseEntity<Cliente> borrar(@PathVariable Integer id){
        OptionalInt indexOpt =   IntStream.range(0, listaClientes.size())
                .filter(i -> listaClientes.get(i).getId().equals(id))
                .findFirst();

        if(indexOpt.isPresent()){
            listaClientes.remove(indexOpt.getAsInt());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
}