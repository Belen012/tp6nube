package dan.tp2021.productos.repository;

import dan.tp2021.productos.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Material, Long> {
    Material findByNombre(String nombre);
    Material findByPrecio(Double precio);
    Material findByStockActualBetween(Integer stockActual, Integer stockActual2);
}
