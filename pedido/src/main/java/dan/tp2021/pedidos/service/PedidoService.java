package dan.tp2021.pedidos.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dan.tp2021.pedidos.domain.EstadoPedido;
import dan.tp2021.pedidos.domain.Obra;
import dan.tp2021.pedidos.domain.Pedido;
import dan.tp2021.pedidos.domain.Material;
import dan.tp2021.pedidos.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	MaterialService materialService;

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ClienteService clienteService;
	
	public Pedido crearPedido(Pedido pedido) {
		Obra obra = pedido.getObra();

		/** Me fijo si tengo stock */
		boolean hayStock = pedido.getDetalle().stream().allMatch(detalle ->  {
			Material material = detalle.getMaterial();
			Integer cantidad = detalle.getCantidad();
			return materialService.stockDisponible(material) >= cantidad;
		});
		
		/** Calculo el costo total de la orden */
		Double totalOrden = pedido.getDetalle().stream()
				.mapToDouble( dp -> dp.getCantidad() * dp.getPrecio())
				.sum();
	
		/** Calculo la nueva deuda */
		Double saldoCliente = clienteService.deudaCliente(obra);		
		Double nuevoSaldo = saldoCliente - totalOrden;
		Boolean generaDeuda = nuevoSaldo < 0;

		if (hayStock) {
				if (!generaDeuda || (generaDeuda && this.esDeBajoRiesgo(obra,nuevoSaldo)))  {
					pedido.setEstado(EstadoPedido.ACEPTADO);
				} else {
					throw new RuntimeException("No tiene aprobacion crediticia");
				}
		} else {
			pedido.setEstado(EstadoPedido.PENDIENTE);
		}

		return pedidoRepository.save(pedido);
	}

	public Pedido actualizarPedido(Long id, EstadoPedido nuevoEstado) {
		Pedido pedidoToUpdate = pedidoRepository.find(id);
		pedidoToUpdate.setEstado(nuevoEstado);

		return pedidoRepository.save(pedidoToUpdate);
	};

	public List<Pedido> getPedidos(Long obraId, EstadoPedido estado, Long clientId) {
		if (obraId != null) {
			return pedidoRepository.findByObra(obraId);
		} else if (estado != null) {
			return pedidoRepository.findByEstado(estado);
		} else if (clientId != null) {
			return pedidoRepository.findByCliente(clientId);
		} else {
			return pedidoRepository.findAll();
		}
	};
	
	boolean verificarStock(Material p,Integer cantidad) {
		return materialService.stockDisponible(p) >= cantidad;
	};

	boolean esDeBajoRiesgo(Obra obra,Double saldoNuevo) {
		Double maximoSaldoNegativo = clienteService.maximoSaldoNegativo(obra);
		Boolean tieneSaldo = Math.abs(saldoNuevo) < maximoSaldoNegativo;
		return tieneSaldo;
	};
}
