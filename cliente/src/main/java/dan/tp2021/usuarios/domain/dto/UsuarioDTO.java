package dan.tp2021.usuarios.domain.dto;

import dan.tp2021.usuarios.domain.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private String user;
    private String password;
    private int tipoUsuario;
}
