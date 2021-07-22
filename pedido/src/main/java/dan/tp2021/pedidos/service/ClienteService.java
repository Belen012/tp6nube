package dan.tp2021.pedidos.service;

import org.springframework.stereotype.Service;
import dan.tp2021.pedidos.domain.Obra;
import dan.tp2021.pedidos.service.ClienteService;

@Service
public class ClienteService {

	public Double deudaCliente(Obra id) {
		return 0.0;
	}

	public Integer situacionCrediticiaBCRA(Obra id) {
		return 0;
	}

	public Double maximoSaldoNegativo(Obra id) {
		return 9000.0;
	}
}
