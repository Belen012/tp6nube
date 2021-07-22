package dan.tp2021.pedidos.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dan.tp2021.pedidos.domain.DetallePedido;
import dan.tp2021.pedidos.domain.PedidoResponse;
import dan.tp2021.pedidos.service.DetalleService;

@RestController
@RequestMapping("/api/detalle")
public class DetalleResource {

	@Autowired
	DetalleService detalleService;

	@PostMapping
	public ResponseEntity<PedidoResponse<DetallePedido>> agregarItem(@RequestBody DetallePedido detalle, @RequestParam Long pedidoId ) {
		return ResponseEntity
			.status(HttpStatus.ACCEPTED)
			.body(new PedidoResponse<DetallePedido>(detalleService.agregarItem(detalle, pedidoId)));
	}

	@PutMapping
	public ResponseEntity<PedidoResponse<DetallePedido>> actualizarItem(@RequestBody DetallePedido detalle, @RequestParam Long pedidoId ) {
		return ResponseEntity
			.status(HttpStatus.ACCEPTED)
			.body(new PedidoResponse<DetallePedido>(detalleService.actualizarItem(detalle, pedidoId)));
	}

	@DeleteMapping
	public ResponseEntity<PedidoResponse<DetallePedido>> eliminarItem(@RequestBody DetallePedido detalle, @RequestParam Long pedidoId ) {
		return ResponseEntity
			.status(HttpStatus.ACCEPTED)
			.body(new PedidoResponse<DetallePedido>(detalleService.deleteItem(detalle, pedidoId)));
	}
}
