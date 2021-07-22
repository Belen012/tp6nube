package dan.tp2021.usuarios.repository;

import dan.tp2021.usuarios.domain.Cliente;
import dan.tp2021.usuarios.domain.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {
}
