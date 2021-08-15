package dan.tp2021.usuarios.domain;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipoObra")
public class TipoObra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int tipoObraCode;
	private String descripcion;

}
