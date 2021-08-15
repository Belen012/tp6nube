package dan.tp2021.usuarios.service.cliente;

import dan.tp2021.usuarios.domain.Cliente;
import dan.tp2021.usuarios.domain.Obra;
import dan.tp2021.usuarios.domain.Usuario;
import dan.tp2021.usuarios.domain.dto.ClienteDTO;
import dan.tp2021.usuarios.exception.*;
import dan.tp2021.usuarios.repository.IClienteRepository;
import dan.tp2021.usuarios.repository.IObraRepository;
import dan.tp2021.usuarios.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Cliente crear(ClienteDTO clienteDTO) throws ObraNotFoundException, UserTypeException, UserTypeNotFoundException, UserNotFoundException {
        this.validateAndSaveUser(clienteDTO.getUser());
        List<Obra> obras = iObraRepository.findAll();
        List<Obra> listaObra = obras.stream().filter(obra -> clienteDTO.getObras_id().contains(obra.getId())).collect(Collectors.toList());
        if(listaObra.isEmpty()){
            throw new ObraNotFoundException();
        }

        //en la guia 3 pide validar el tipo de usuario -> Solo se puede dar de alta un cliente para comprar ONLINE,
        //                                                  si y solo si la situación crediticia es de TIPO 1 o 2.
        if (clienteDTO.getUser().getTipoUsuario().getTipoUsuarioCode() == 1 || clienteDTO.getUser().getTipoUsuario().getTipoUsuarioCode() == 2 ){
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
        }else throw new UserTypeException();

    }


    @Override
    public Cliente update(ClienteDTO clienteDTO) throws ClienteNotFoundException, ObraNotFoundException, UserTypeException, UserTypeNotFoundException, UserNotFoundException {
        Cliente cliente = iClienteRepository.findByClienteCode(clienteDTO.getClienteCode());

        if(cliente == null){
            throw new ClienteNotFoundException();
        }
        iClienteRepository.delete(cliente);

        return this.crear(clienteDTO);
    }

    @Override //hay que ver como se actualiza esa fecha desde el microservicio de pedidos
    public void eliminar(int clienteCode) throws ClienteNotFoundException, ClienteCannotDeleteException {
        Cliente cliente = iClienteRepository.findByClienteCode(clienteCode);

        if(cliente == null){
            throw new ClienteNotFoundException(); //si no lo encuentra, el cliente no existe, no se puede eliminar
        }

        if(cliente.getFechaBaja() != null){
            iClienteRepository.delete(cliente);
        }
        else throw new ClienteCannotDeleteException();

    }


    private void validateAndSaveUser(Usuario user) throws UserTypeNotFoundException, UserNotFoundException {
        //valido que el usuario no sea vacio
        if(user == null){
            throw new UserNotFoundException();
        }

        //valido que tenga un tipo de usuario
        if(user.getTipoUsuario() == null){
            throw new UserTypeNotFoundException();
        }

        iUsuarioRepository.save(user);

    }


    @Override //solo se puede consultar los que tengan fecha baja null
    public ClienteDTO getCliente(String cuit, String razonSocial, int obraCode) throws ClienteDateInvalidException, ClienteNotFoundException, ClienteCannotSearchedException {

        if(cuit != null) {
            Cliente response = iClienteRepository.findByCuit(cuit);
            System.out.println("ENTRA ACA"+response);

            if(response == null){
                throw new ClienteNotFoundException();
            }
            if(response.getFechaBaja() != null){
                throw new ClienteDateInvalidException();
            }
            return this.mapperToDTO(response);
        }

        if(razonSocial != null) {
            Cliente response = iClienteRepository.findByRazonSocial(razonSocial);
            System.out.println("ENTRA ACA"+response);
            if(response == null){
                throw new ClienteNotFoundException();
            }
            if(response.getFechaBaja() != null){
                throw new ClienteDateInvalidException();
            }
            return this.mapperToDTO(response);
        }

        if(obraCode != 0) {
            Obra obra = iObraRepository.findByObraCode(obraCode);
            if(obra == null){
                throw new ClienteNotFoundException();
            }
            List<Cliente> listClientes = iClienteRepository.findAll();
            Cliente response = listClientes.stream().filter(c -> c.getObras().contains(obra)).findFirst().get();

            if(response == null){
                throw new ClienteNotFoundException();
            }
            if(response.getFechaBaja() != null){
                throw new ClienteDateInvalidException();
            }
           return this.mapperToDTO(response);
        }

        throw new ClienteCannotSearchedException();

    }

    private ClienteDTO mapperToDTO(Cliente response) {
        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setClienteCode(response.getClienteCode());
        clienteDTO.setRazonSocial(response.getRazonSocial());
        clienteDTO.setCuit(response.getCuit());
        clienteDTO.setMail(response.getMail());
        clienteDTO.setMaxCuentaCorriente(response.getMaxCuentaCorriente());
        clienteDTO.setHabilitadoOnline(response.getHabilitadoOnline());
        clienteDTO.setUser(response.getUser());

        List<Long> listObraId = response.getObras().stream().map(Obra::getId).collect(Collectors.toList());
        clienteDTO.setObras_id(listObraId);

        return clienteDTO;
    }

}
