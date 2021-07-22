package dan.tp2021.pedidos.repository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import dan.tp2021.pedidos.domain.DetallePedido;

@Repository
public class DetalleRepository  {

	public DetallePedido save(DetallePedido nuevoDetalle) {
		return nuevoDetalle;
	}

	public DetallePedido find(Long id) {
		return new DetallePedido();
	}

	public List<DetallePedido> findAll() {
		List<DetallePedido> detalles = new ArrayList<DetallePedido>();
		return detalles;
	}
}
