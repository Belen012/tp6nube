package dan.tp2021.usuarios.repository;

import dan.tp2021.usuarios.domain.Cliente;
import dan.tp2021.usuarios.domain.TipoObra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoObraRepository extends JpaRepository<TipoObra, Long> {
    TipoObra findByTipoObraCode(int tipoObraCode);
}
