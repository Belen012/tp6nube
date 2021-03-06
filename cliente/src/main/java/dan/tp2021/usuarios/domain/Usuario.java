package dan.tp2021.usuarios.domain;

import lombok.*;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int usuarioCode;
	private String user;
	private String password;
	@OneToOne
	private TipoUsuario tipoUsuario;

	
}
