package dan.tp2021.pedidos.repository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dan.tp2021.pedidos.domain.EstadoPedido;
import dan.tp2021.pedidos.domain.Pedido;

@Repository
public class PedidoRepository  {

    public Integer getId(Pedido pedido) {
        return pedido.getId();
    }

    public void setId(Pedido pedido, Integer id) {
        pedido.setId(id);
    }

	public Pedido save(Pedido nuevoPedido) {
		return nuevoPedido;
	}

	public Pedido find(Long id) {
		return new Pedido();
	}

	public List<Pedido> findByObra(Long obraId) {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		return pedidos;
	}

	public List<Pedido> findByEstado(EstadoPedido estado) {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		return pedidos;
	}

	public List<Pedido> findByCliente(Long clientId) {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		return pedidos;
	}

	public List<Pedido> findAll() {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		return pedidos;
	}
}
