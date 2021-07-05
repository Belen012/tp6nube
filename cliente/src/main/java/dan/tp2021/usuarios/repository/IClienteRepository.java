package dan.tp2021.usuarios.repository;

import dan.tp2021.usuarios.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
