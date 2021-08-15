package dan.tp2021.usuarios.repository;

import dan.tp2021.usuarios.domain.Cliente;
import dan.tp2021.usuarios.domain.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCuit(String cuit);
    Cliente findByRazonSocial(String razonSocial);
    Cliente findByClienteCode(int clienteCode);


}
