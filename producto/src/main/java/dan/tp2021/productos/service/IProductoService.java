package dan.tp2021.productos.service;

import dan.tp2021.productos.domain.Material;
import dan.tp2021.productos.exception.MaterialIncompletException;
import dan.tp2021.productos.exception.ProductoCannotSearchedException;
import dan.tp2021.productos.exception.ProductoNotFoundException;

public interface IProductoService {
    Material crear(Material material) throws MaterialIncompletException;

    Material update(Material material) throws ProductoNotFoundException, MaterialIncompletException;


    Material getMaterial(String nombre, Integer stockActual, Integer stockMinimo, Double precio) throws ProductoNotFoundException, ProductoCannotSearchedException;
}
