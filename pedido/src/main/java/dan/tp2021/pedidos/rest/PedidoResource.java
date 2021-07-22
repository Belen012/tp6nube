package dan.tp2021.pedidos.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dan.tp2021.pedidos.domain.DetallePedido;
import dan.tp2021.pedidos.domain.EstadoPedido;
import dan.tp2021.pedidos.domain.Obra;
import dan.tp2021.pedidos.domain.Pedido;
import dan.tp2021.pedidos.domain.PedidoResponse;
import dan.tp2021.pedidos.service.PedidoService;

@RestController
@RequestMapping("/api/pedido")
public class PedidoResource {
	
	@Autowired
	PedidoService pedidoService;

	@PostMapping
	public ResponseEntity<PedidoResponse<Pedido>> crearPedido(@RequestBody Pedido pedido) {
		Obra obra = pedido.getObra();
		List<DetallePedido> detalles = pedido.getDetalle();
		if (obra == null) {
			return ResponseEntity
			.status(HttpStatus.NOT_ACCEPTABLE)
			.body(new PedidoResponse<Pedido>(null,"Debes enviar una obra."));
		} else if (detalles == null || detalles.isEmpty()) {
			return ResponseEntity
			.status(HttpStatus.NOT_ACCEPTABLE)
			.body(new PedidoResponse<Pedido>(null,"Debes agregar items al pedido."));
		} else if (detalles.stream().anyMatch(detalle -> detalle.getCantidad() == null)) {
			return ResponseEntity
			.status(HttpStatus.NOT_ACCEPTABLE)
			.body(new PedidoResponse<Pedido>(null,"Todos los detalles deben especificar una cantidad."));
		} else {
			return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(new PedidoResponse<Pedido>(pedidoService.crearPedido(pedido)));
		}
	}

	@PutMapping
	public ResponseEntity<PedidoResponse<Pedido>> updatePedido(@RequestParam Long id, @RequestParam EstadoPedido nuevoEstado) {
		Pedido updatedPedido = pedidoService.actualizarPedido(id, nuevoEstado);
		if (updatedPedido == null) {
			return ResponseEntity
			.status(HttpStatus.NOT_ACCEPTABLE)
			.body(new PedidoResponse<Pedido>(null,"Parece que no se pudo actualizar el pedido correctamente."));
		} else {
			return ResponseEntity
			.status(HttpStatus.ACCEPTED)
			.body(new PedidoResponse<Pedido>(updatedPedido));
		}
	}

	@GetMapping
	public ResponseEntity<PedidoResponse<List<Pedido>>> getPedido(
		@RequestParam(required = false) Long obraId, 
		@RequestParam(required = false) EstadoPedido estado, 
		@RequestParam(required = false) Long clientId
	) {
		return ResponseEntity
		.status(HttpStatus.ACCEPTED)
		.body(new PedidoResponse<List<Pedido>>(pedidoService.getPedidos(obraId, estado, clientId)));
	}
}
