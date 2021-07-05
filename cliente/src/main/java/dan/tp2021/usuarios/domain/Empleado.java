package dan.tp2021.usuarios.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleado")
public class Empleado {
	@Id
	private Long id;
	private String mail;
	@OneToOne
	private Usuario user;

}
