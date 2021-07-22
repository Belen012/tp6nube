package dan.tp2021.pedidos.service;

import org.springframework.stereotype.Service;
import dan.tp2021.pedidos.domain.Material;
import dan.tp2021.pedidos.service.MaterialService;

@Service
public class MaterialService {

	public Integer stockDisponible(Material m) {
		return 4;
	}
}
