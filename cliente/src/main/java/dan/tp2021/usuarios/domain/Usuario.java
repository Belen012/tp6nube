package dan.tp2021.usuarios.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	private Long id;
	private String user;
	private String password;
	@OneToOne
	private TipoUsuario tipoUsuario;

	
}
