package com.nemoralia.api.controlador;

import com.nemoralia.api.modelo.ItemCarrito;
import com.nemoralia.api.modelo.Producto;
import com.nemoralia.api.repositorio.ItemCarritoRepositorio;
import com.nemoralia.api.repositorio.ProductoRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Pruebas unitarias de las reglas de negocio del carrito.
 * Ajuste GA11-220501098-AA3-EV01.
 *
 * @author Julian Andres Trujillo Morales
 */
class CarritoControladorTest {

    private ItemCarritoRepositorio itemRepositorio;
    private ProductoRepositorio productoRepositorio;
    private CarritoControlador controlador;

    @BeforeEach
    void preparar() {
        itemRepositorio = mock(ItemCarritoRepositorio.class);
        productoRepositorio = mock(ProductoRepositorio.class);
        controlador = new CarritoControlador(itemRepositorio, productoRepositorio);
    }

    @Test
    @DisplayName("Agrega un producto con stock suficiente")
    void agregaProductoConStock() {
        when(productoRepositorio.findById(1)).thenReturn(Optional.of(new Producto("Camiseta Nemoralia", "Algodon", 89900.0, 20)));
        when(itemRepositorio.save(any(ItemCarrito.class))).thenAnswer(i -> i.getArgument(0));

        ResponseEntity<?> respuesta = controlador.agregarItem(new ItemCarrito(1, 1, 2));

        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());
    }

    @Test
    @DisplayName("Rechaza una cantidad igual a cero")
    void rechazaCantidadCero() {
        ResponseEntity<?> respuesta = controlador.agregarItem(new ItemCarrito(1, 1, 0));

        assertEquals(HttpStatus.BAD_REQUEST, respuesta.getStatusCode());
        verify(itemRepositorio, never()).save(any(ItemCarrito.class));
    }

    @Test
    @DisplayName("Rechaza una cantidad mayor al stock")
    void rechazaCantidadMayorAlStock() {
        when(productoRepositorio.findById(1)).thenReturn(Optional.of(new Producto("Camiseta Nemoralia", "Algodon", 89900.0, 5)));

        ResponseEntity<?> respuesta = controlador.agregarItem(new ItemCarrito(1, 1, 999));

        assertEquals(HttpStatus.BAD_REQUEST, respuesta.getStatusCode());
        verify(itemRepositorio, never()).save(any(ItemCarrito.class));
    }

    @Test
    @DisplayName("Responde 404 si el producto no existe")
    void rechazaProductoInexistente() {
        when(productoRepositorio.findById(999999)).thenReturn(Optional.empty());

        ResponseEntity<?> respuesta = controlador.agregarItem(new ItemCarrito(1, 999999, 1));

        assertEquals(HttpStatus.NOT_FOUND, respuesta.getStatusCode());
    }
}
