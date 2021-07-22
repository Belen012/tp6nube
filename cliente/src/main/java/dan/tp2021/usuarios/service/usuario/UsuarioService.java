package dan.tp2021.usuarios.service.usuario;

import dan.tp2021.usuarios.repository.IUsuarioRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {
    IUsuarioRepository iUsuarioRepository;

}
