package dan.tp2021.usuarios.service.cliente;

import dan.tp2021.usuarios.domain.Cliente;
import dan.tp2021.usuarios.domain.dto.ClienteDTO;
import dan.tp2021.usuarios.exception.*;

public interface IClienteService {
    Cliente crear(ClienteDTO clienteDTO) throws ObraNotFoundException, UserTypeException, UserTypeNotFoundException, UserNotFoundException;

    Cliente update(ClienteDTO clienteDTO) throws ClienteNotFoundException, ObraNotFoundException, UserTypeException, UserTypeNotFoundException, UserNotFoundException;

    void eliminar(int clienteID) throws ClienteNotFoundException, ClienteCannotDeleteException;

    ClienteDTO getCliente(String cuit, String razonSocial, int obraCode) throws ClienteDateInvalidException, ClienteNotFoundException, ClienteCannotSearchedException;
}
