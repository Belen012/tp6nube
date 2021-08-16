package dan.tp2021.productos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movimientosStock")
public class MovimientosStock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int movimientoStockCode;
	@OneToOne
	private DetallePedido detallePedido;
	@OneToOne
	private DetalleProvision detalleProvision;
	@OneToOne
	private Material material;
	private Integer cantidadEntrada;
	private Integer cantidadSalida;
	private Instant fecha;

	
}
