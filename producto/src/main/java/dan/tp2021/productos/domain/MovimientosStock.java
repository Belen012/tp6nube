package dan.tp2021.productos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movimientosStock")
public class MovimientosStock {
	
	private Long id;
	private int movimientoStockCode;
	private DetallePedido detallePedido;
	private DetalleProvision detalleProvision;
	private Material material;
	private Integer cantidadEntrada;
	private Integer cantidadSalida;
	private Instant fecha;

	
}
