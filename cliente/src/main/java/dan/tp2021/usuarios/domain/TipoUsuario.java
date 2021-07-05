package dan.tp2021.usuarios.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipoUsuario")
public class TipoUsuario {
	@Id
	private Long id;
	private String tipo;

	
}
