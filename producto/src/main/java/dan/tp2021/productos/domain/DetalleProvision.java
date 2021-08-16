package dan.tp2021.productos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalleProvision")
public class DetalleProvision {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int detalleProvisionCode;
	@OneToOne
	private Material material;
	private Integer cantidad;
	
}
