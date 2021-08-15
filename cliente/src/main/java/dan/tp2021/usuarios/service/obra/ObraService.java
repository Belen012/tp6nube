package dan.tp2021.usuarios.service.obra;

import dan.tp2021.usuarios.domain.Cliente;
import dan.tp2021.usuarios.domain.Obra;
import dan.tp2021.usuarios.domain.TipoObra;
import dan.tp2021.usuarios.exception.ClienteNotFoundException;
import dan.tp2021.usuarios.exception.ObraIncompletException;
import dan.tp2021.usuarios.exception.ObraNotFoundException;
import dan.tp2021.usuarios.exception.TipoObraNotFoundException;
import dan.tp2021.usuarios.repository.IClienteRepository;
import dan.tp2021.usuarios.repository.IObraRepository;
import dan.tp2021.usuarios.repository.ITipoObraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ObraService implements IObraService{

    IObraRepository iObraRepository;

    IClienteRepository iClienteRepository;

    ITipoObraRepository iTipoObraRepository;


    @Override
    public Obra crear(Obra obra) throws ObraIncompletException, ObraNotFoundException {
        this.validateObra(obra);
        iObraRepository.save(obra);
        return obra;
    }

    private void validateObra(Obra obra) throws ObraNotFoundException, ObraIncompletException {
        if(obra == null){
            throw new ObraNotFoundException();
        }

        if(obra.getObraCode() == -1  && obra.getLatitud() == null && obra.getLongitud() == null && obra.getTipo() == null){
            throw new ObraIncompletException();
        }
    }

    @Override
    public Obra update(Obra obra) throws ObraNotFoundException, ObraIncompletException {
        Obra obra1 = iObraRepository.findByObraCode(obra.getObraCode());

        if(obra1 == null){
            throw new ObraNotFoundException();
        }

        iObraRepository.delete(obra1);

        return this.crear(obra);

    }

    @Override
    public List<Obra> getObras(int clienteCode, int tipoObraCode) throws ClienteNotFoundException, TipoObraNotFoundException {
        Cliente cliente = iClienteRepository.findByClienteCode(clienteCode);

        if(cliente == null){
            throw new ClienteNotFoundException();
        }

        if(tipoObraCode != 0){
            TipoObra tipoObra = iTipoObraRepository.findByTipoObraCode(tipoObraCode);
            if(tipoObra == null){
                throw new TipoObraNotFoundException();
            }

            return cliente.getObras().stream().filter(t -> t.getTipo().getTipoObraCode()==tipoObraCode).collect(Collectors.toList());
        }

        return cliente.getObras();
    }
















}
