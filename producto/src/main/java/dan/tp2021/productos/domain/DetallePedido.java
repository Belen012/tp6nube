package dan.tp2021.productos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detallePedido")
public class DetallePedido {
	private Long id;
	private int detallePedidoCode;
	private Material material;
	private Integer cantidad;
	
}
