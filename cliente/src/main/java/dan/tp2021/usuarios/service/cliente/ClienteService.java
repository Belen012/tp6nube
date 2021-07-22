package dan.tp2021.usuarios.service.cliente;

import dan.tp2021.usuarios.domain.Cliente;
import dan.tp2021.usuarios.domain.Obra;
import dan.tp2021.usuarios.domain.Usuario;
import dan.tp2021.usuarios.domain.dto.ClienteDTO;
import dan.tp2021.usuarios.exception.ClienteNotFoundException;
import dan.tp2021.usuarios.exception.ObraNotFoundException;
import dan.tp2021.usuarios.repository.IClienteRepository;
import dan.tp2021.usuarios.repository.IObraRepository;
import dan.tp2021.usuarios.repository.IUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.AssociationOverride;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    IClienteRepository iClienteRepository;
    @Autowired
    IObraRepository iObraRepository;
    @Autowired
    IUsuarioRepository iUsuarioRepository;


    @Override
    public Cliente crear(ClienteDTO clienteDTO) throws ObraNotFoundException {
        this.altaUsuario(clienteDTO.getUser());
        List<Obra> obras = iObraRepository.findAll();
        List<Obra> listaObra = obras.stream().filter(obra -> clienteDTO.getObras_id().contains(obra.getId())).collect(Collectors.toList());
        if(listaObra.isEmpty()){
            throw new ObraNotFoundException();
        }

        Cliente cliente = new Cliente();
        cliente.setRazonSocial(clienteDTO.getRazonSocial());
        cliente.setCuit(clienteDTO.getCuit());
        cliente.setMail(clienteDTO.getMail());
        cliente.setMaxCuentaCorriente(clienteDTO.getMaxCuentaCorriente());
        cliente.setHabilitadoOnline(clienteDTO.getHabilitadoOnline());
        cliente.setUser(cliente.getUser());
        cliente.setObras(listaObra);
        iClienteRepository.save(cliente);

        return cliente;
    }

    @Override
    public Cliente update(ClienteDTO clienteDTO) throws ClienteNotFoundException, ObraNotFoundException {
        Optional<Cliente> cliente = iClienteRepository.findAll().stream().filter(
                c -> c.getCuit().equals(clienteDTO.getCuit())).findFirst();

        if(cliente.isEmpty()){
            throw new ClienteNotFoundException();
        }

        return this.crear(clienteDTO);
    }

    @Override
    public void eliminar(int clienteID) {
        Cliente cliente = iClienteRepository.findAll().stream().filter(
                c -> c.getClienteId() == clienteID).findFirst().get();

        /* se debe verificar que no se puede eliminar si ya ha realizado
        algún pedido, por lo que en ese caso, debe agregar un atributo, "fechaBaja" y asignarle
        una fecha. Todos los clientes activos son aquellos que no tienen fechaBaja (o es null).*/

        //falta verificar eso


        iClienteRepository.delete(cliente);
    }

    private void altaUsuario(Usuario user) {
        //validar si esta bien el usuario
        iUsuarioRepository.save(user);

    }
}
