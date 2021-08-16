package dan.tp2021.productos.repository;

import dan.tp2021.productos.domain.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Unidad, Long> {
}
