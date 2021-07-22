package dan.tp2021.pedidos.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dan.tp2021.pedidos.domain.DetallePedido;
import dan.tp2021.pedidos.domain.Pedido;
import dan.tp2021.pedidos.repository.DetalleRepository;
import dan.tp2021.pedidos.repository.PedidoRepository;

@Service
public class DetalleService {
	
	@Autowired
	DetalleRepository detalleRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	public DetallePedido agregarItem(DetallePedido detalle, Long pedidoId) {
		Pedido pedido = pedidoRepository.find(pedidoId);
		pedido.getDetalle().add(detalle);
		pedidoRepository.save(pedido);
		return detalle;
	}
	
	public DetallePedido actualizarItem(DetallePedido detalleActualizado, Long pedidoId) {
		Pedido pedido = pedidoRepository.find(pedidoId);
		pedido.setDetalle(pedido.getDetalle().stream().map(detalle -> detalle.getId() == detalleActualizado.getId() ? detalleActualizado : detalle).collect(Collectors.toList()));
		pedidoRepository.save(pedido);
		return detalleActualizado;
	}

	public DetallePedido deleteItem(DetallePedido detalleActualizado, Long pedidoId) {
		Pedido pedido = pedidoRepository.find(pedidoId);
		pedido.setDetalle(pedido.getDetalle().stream().filter(detalle -> detalle.getId() != detalleActualizado.getId()).collect(Collectors.toList()));
		pedidoRepository.save(pedido);
		return detalleActualizado;
	}
}
