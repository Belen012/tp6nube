package dan.tp2021.productos.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "material")
public class Material {

	private Long id;
	private int materialCode;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Integer stockActual;
	private Integer stockMinimo;

}
