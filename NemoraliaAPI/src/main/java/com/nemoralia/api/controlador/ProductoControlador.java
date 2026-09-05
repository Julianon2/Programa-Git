package com.nemoralia.api.controlador;

import com.nemoralia.api.modelo.Producto;
import com.nemoralia.api.repositorio.ProductoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST del catalogo de productos de Nemoralia.
 *
 * @author Julian Andres Trujillo Morales
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoControlador {

    private final ProductoRepositorio productoRepositorio;

    @Autowired
    public ProductoControlador(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    @GetMapping
    public List<Producto> consultarTodos() {
        return productoRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> consultarPorId(@PathVariable Integer id) {
        return productoRepositorio.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> insertar(@RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoRepositorio.save(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Integer id, @RequestBody Producto datosProducto) {
        return productoRepositorio.findById(id)
                .map(producto -> {
                    producto.setNombre(datosProducto.getNombre());
                    producto.setDescripcion(datosProducto.getDescripcion());
                    producto.setPrecio(datosProducto.getPrecio());
                    producto.setStock(datosProducto.getStock());
                    return ResponseEntity.ok(productoRepositorio.save(producto));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!productoRepositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        productoRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
