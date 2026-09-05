package com.nemoralia.api.controlador;

import com.nemoralia.api.dto.RespuestaDTO;
import com.nemoralia.api.modelo.ItemCarrito;
import com.nemoralia.api.repositorio.ItemCarritoRepositorio;
import com.nemoralia.api.repositorio.ProductoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST del carrito de compras de Nemoralia. Permite agregar
 * productos al carrito de un usuario, consultarlos y eliminarlos,
 * validando que el producto referenciado exista en el catalogo.
 *
 * @author Julian Andres Trujillo Morales
 */
@RestController
@RequestMapping("/api/carrito")
public class CarritoControlador {

    private final ItemCarritoRepositorio itemCarritoRepositorio;
    private final ProductoRepositorio productoRepositorio;

    @Autowired
    public CarritoControlador(ItemCarritoRepositorio itemCarritoRepositorio, ProductoRepositorio productoRepositorio) {
        this.itemCarritoRepositorio = itemCarritoRepositorio;
        this.productoRepositorio = productoRepositorio;
    }

    /**
     * Consulta todos los items del carrito de un usuario.
     */
    @GetMapping("/{idUsuario}")
    public List<ItemCarrito> consultarCarrito(@PathVariable Integer idUsuario) {
        return itemCarritoRepositorio.findByIdUsuario(idUsuario);
    }

    /**
     * Agrega un producto al carrito de un usuario, validando que el
     * producto exista y que haya stock suficiente.
     */
    @PostMapping
    public ResponseEntity<?> agregarItem(@RequestBody ItemCarrito item) {

        if (item.getCantidad() == null || item.getCantidad() <= 0) {
            return ResponseEntity.badRequest()
                    .body(new RespuestaDTO("La cantidad debe ser mayor a cero."));
        }

        return productoRepositorio.findById(item.getIdProducto())
                .map(producto -> {
                    if (producto.getStock() < item.getCantidad()) {
                        return ResponseEntity.badRequest()
                                .body(new RespuestaDTO("No hay stock suficiente para este producto."));
                    }
                    ItemCarrito itemGuardado = itemCarritoRepositorio.save(item);
                    return ResponseEntity.status(HttpStatus.CREATED).body(itemGuardado);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new RespuestaDTO("El producto indicado no existe.")));
    }

    /**
     * Elimina un item del carrito.
     */
    @DeleteMapping("/{idItem}")
    public ResponseEntity<Void> eliminarItem(@PathVariable Integer idItem) {
        if (!itemCarritoRepositorio.existsById(idItem)) {
            return ResponseEntity.notFound().build();
        }
        itemCarritoRepositorio.deleteById(idItem);
        return ResponseEntity.noContent().build();
    }
}
