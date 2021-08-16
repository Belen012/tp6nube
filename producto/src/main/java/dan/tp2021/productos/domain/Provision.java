package dan.tp2021.productos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "provision")
public class Provision {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int provisionCode;
	private Instant fechaProvision;
	@OneToMany
	@JoinColumn(name = "detalle")
	private List<DetalleProvision> detalle;

	
}
