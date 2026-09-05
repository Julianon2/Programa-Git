package com.nemoralia.api.repositorio;

import com.nemoralia.api.modelo.ItemCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio de acceso a datos para la entidad ItemCarrito.
 *
 * @author Julian Andres Trujillo Morales
 */
@Repository
public interface ItemCarritoRepositorio extends JpaRepository<ItemCarrito, Integer> {

    /**
     * Consulta todos los items del carrito de un usuario especifico.
     */
    List<ItemCarrito> findByIdUsuario(Integer idUsuario);
}
