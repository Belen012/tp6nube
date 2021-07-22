package dan.tp2021.usuarios.repository;

import dan.tp2021.usuarios.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
}
