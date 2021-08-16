package dan.tp2021.productos.service;

import dan.tp2021.productos.domain.Material;
import dan.tp2021.productos.exception.MaterialIncompletException;
import dan.tp2021.productos.exception.ProductoCannotSearchedException;
import dan.tp2021.productos.exception.ProductoNotFoundException;
import dan.tp2021.productos.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoService implements IProductoService{

    IProductoRepository iProductoRepository;

    @Override
    public Material crear(Material material) throws MaterialIncompletException {
        this.validateMaterial(material);
        iProductoRepository.save(material);
        return material;
    }

    private void validateMaterial(Material material) throws MaterialIncompletException {
        if(material.getNombre() == null ||
                material.getPrecio() == null ||
                material.getStockActual() == null ||
                material.getStockMinimo() == null){
            throw new MaterialIncompletException();
        }
    }

    @Override
    public Material update(Material material) throws ProductoNotFoundException, MaterialIncompletException {
        Optional<Material> material1 = iProductoRepository.findById(material.getId());
        if(material1.isEmpty()){
            throw new ProductoNotFoundException();
        }
        iProductoRepository.delete(material1.get());
        this.crear(material);
        return material;
    }

    @Override
    public Material getMaterial(String nombre,  Integer stockActual, Integer stockMinimo, Double precio) throws ProductoNotFoundException, ProductoCannotSearchedException {
        if(nombre != null){
            Material material1 = iProductoRepository.findByNombre(nombre);
            if(material1 == null){
                throw new ProductoNotFoundException();
            }
            return material1;
        }

        if(stockActual != null && stockMinimo != null){ //revisar
            Material material1 = iProductoRepository.findByStockActualBetween(stockActual,stockMinimo);
            if(material1 == null){
                throw new ProductoNotFoundException();
            }
            return material1;
        }

        if(precio != null){
            Material material1 = iProductoRepository.findByPrecio(precio);
            if(material1 == null){
                throw new ProductoNotFoundException();
            }
            return material1;
        }
        throw new ProductoCannotSearchedException();
    }

}
