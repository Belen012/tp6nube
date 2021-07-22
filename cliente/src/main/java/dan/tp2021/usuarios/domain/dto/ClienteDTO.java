package dan.tp2021.usuarios.domain.dto;

import dan.tp2021.usuarios.domain.Obra;
import dan.tp2021.usuarios.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private int clienteId;
    private String razonSocial;
    private String cuit;
    private String mail;
    private Double maxCuentaCorriente;
    private Boolean habilitadoOnline;
    private Usuario user;
    private List<Long> obras_id;

}
