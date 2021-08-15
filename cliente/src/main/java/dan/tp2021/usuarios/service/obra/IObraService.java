package dan.tp2021.usuarios.service.obra;

import dan.tp2021.usuarios.domain.Obra;
import dan.tp2021.usuarios.exception.ClienteNotFoundException;
import dan.tp2021.usuarios.exception.ObraIncompletException;
import dan.tp2021.usuarios.exception.ObraNotFoundException;
import dan.tp2021.usuarios.exception.TipoObraNotFoundException;

import java.util.List;

public interface IObraService {
    Obra crear(Obra obra) throws ObraIncompletException, ObraNotFoundException;

    Obra update(Obra obra) throws ObraNotFoundException, ObraIncompletException;

    List<Obra> getObras(int obraCode, int tipoObraCode) throws ClienteNotFoundException, TipoObraNotFoundException;
}
