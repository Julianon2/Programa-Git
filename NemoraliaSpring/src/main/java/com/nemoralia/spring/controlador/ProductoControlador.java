package com.nemoralia.spring.controlador;

import com.nemoralia.spring.modelo.Producto;
import com.nemoralia.spring.repositorio.ProductoRepositorio;

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
import java.util.Optional;

/**
 * Controlador REST del modulo de productos de Nemoralia, construido con
 * el framework Spring Boot. Expone las operaciones CRUD del catalogo
 * de productos como servicios web.
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

    /**
     * Consulta todos los productos registrados.
     */
    @GetMapping
    public List<Producto> consultarTodos() {
        return productoRepositorio.findAll();
    }

    /**
     * Consulta un producto por su identificador.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Producto> consultarPorId(@PathVariable Integer id) {
        Optional<Producto> producto = productoRepositorio.findById(id);
        return producto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Registra un nuevo producto.
     */
    @PostMapping
    public ResponseEntity<Producto> insertar(@RequestBody Producto producto) {
        Producto productoGuardado = productoRepositorio.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoGuardado);
    }

    /**
     * Actualiza los datos de un producto existente.
     */
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

    /**
     * Elimina un producto por su identificador.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!productoRepositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        productoRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
