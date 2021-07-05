package dan.tp2021.usuarios.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
    private Long id;
    private String razonSocial;
    private String cuit;
    private String mail;
    private Double maxCuentaCorriente;
    private Boolean habilitadoOnline;
    @OneToOne
    private Usuario user;
    @OneToMany
    private List<Obra> obras;

	public Cliente(){
		this.obras = new ArrayList<>();
	}
}
