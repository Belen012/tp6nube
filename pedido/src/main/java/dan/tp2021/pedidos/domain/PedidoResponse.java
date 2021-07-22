package dan.tp2021.pedidos.domain;

public class PedidoResponse<T> {
	public String error = "";
	public T data;

	public PedidoResponse(T data) {
		this.data = data;
	};
	
	public PedidoResponse(T data, String error) {
		this.data = data;
		this.error = error;
	};
}
