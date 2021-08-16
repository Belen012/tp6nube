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
@Table(name = "detalleProvision")
public class DetalleProvision {
	private Long id;
	private int detalleProvisionCode;
	private Material material;
	private Integer cantidad;
	
}
