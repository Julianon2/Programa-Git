package com.nemoralia.api.repositorio;

import com.nemoralia.api.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de acceso a datos para la entidad Producto.
 *
 * @author Julian Andres Trujillo Morales
 */
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
