package dan.tp2021.usuarios.repository;

import dan.tp2021.usuarios.domain.Cliente;
import dan.tp2021.usuarios.domain.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Long> {
}
