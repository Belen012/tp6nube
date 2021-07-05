package dan.tp2021.usuarios.domain.dto;

import dan.tp2021.usuarios.domain.Obra;
import dan.tp2021.usuarios.domain.Usuario;


import java.util.List;

public class ClienteDTO {
    private Integer id;
    private String razonSocial;
    private String cuit;
    private String mail;
    private Double maxCuentaCorriente;
    private Boolean habilitadoOnline;
    private Usuario user;
    private List<Obra> obras;

}
