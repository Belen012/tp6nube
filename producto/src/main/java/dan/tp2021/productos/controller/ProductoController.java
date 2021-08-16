package dan.tp2021.productos.controller;

import dan.tp2021.productos.domain.Material;
import dan.tp2021.productos.exception.MaterialIncompletException;
import dan.tp2021.productos.exception.ProductoCannotSearchedException;
import dan.tp2021.productos.exception.ProductoNotFoundException;
import dan.tp2021.productos.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    IProductoService iProductoService;

    @PostMapping("/crear")
    public ResponseEntity<Material> crear(@RequestBody Material material) throws MaterialIncompletException {
        return new ResponseEntity<>(iProductoService.crear(material), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Material> update(@RequestBody Material material) throws ProductoNotFoundException, MaterialIncompletException {
        return new ResponseEntity<>(iProductoService.update(material), HttpStatus.OK);
    }

    @GetMapping("/obtenerCliente")
    public ResponseEntity<Material> getProducto(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Integer stockActual,
            @RequestParam(required = false) Integer stockMinimo,
            @RequestParam(required = false) Double precio) throws ProductoNotFoundException, ProductoCannotSearchedException {
        return new ResponseEntity<>(iProductoService.getMaterial(nombre, stockActual, stockMinimo, precio), HttpStatus.OK);
    }
}
