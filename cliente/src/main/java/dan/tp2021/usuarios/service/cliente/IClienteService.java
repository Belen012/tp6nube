package dan.tp2021.usuarios.service.cliente;

import dan.tp2021.usuarios.domain.Cliente;
import dan.tp2021.usuarios.domain.dto.ClienteDTO;
import dan.tp2021.usuarios.exception.ClienteNotFoundException;
import dan.tp2021.usuarios.exception.ObraNotFoundException;

public interface IClienteService {
    Cliente crear(ClienteDTO clienteDTO) throws ObraNotFoundException;

    Cliente update(ClienteDTO clienteDTO) throws ClienteNotFoundException, ObraNotFoundException;

    void eliminar(int clienteID);
}
