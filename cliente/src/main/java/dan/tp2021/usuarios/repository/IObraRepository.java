package dan.tp2021.usuarios.repository;

import dan.tp2021.usuarios.domain.Obra;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface IObraRepository extends JpaRepository<Obra, Long> {
    Obra findAllById(Long id);
}
