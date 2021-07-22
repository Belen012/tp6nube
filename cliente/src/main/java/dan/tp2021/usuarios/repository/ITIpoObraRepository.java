package dan.tp2021.usuarios.repository;

import dan.tp2021.usuarios.domain.Cliente;
import dan.tp2021.usuarios.domain.TipoObra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITIpoObraRepository extends JpaRepository<TipoObra, Long> {
}
