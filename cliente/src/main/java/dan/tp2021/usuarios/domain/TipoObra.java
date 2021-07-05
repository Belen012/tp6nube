package dan.tp2021.usuarios.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipoObra")
public class TipoObra {
	@Id
	private Long id;
	private String descripcion;

}
