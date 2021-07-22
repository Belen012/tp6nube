package dan.tp2021.pedidos.domain;

public class DetallePedido {
	private Integer id;
	private Material material;
	private Integer cantidad;
	private Double precio;
	
	public DetallePedido() {}
	
	public DetallePedido(Material material, Integer cantidad, Double precio) {
		super();
		this.material = material;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
}
