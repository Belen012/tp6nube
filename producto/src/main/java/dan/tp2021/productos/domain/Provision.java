package dan.tp2021.productos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "provision")
public class Provision {

	private Long id;
	private int provisionCode;
	private Instant fechaProvision;
	private List<DetalleProvision> detalle;

	
}
