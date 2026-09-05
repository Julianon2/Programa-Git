package com.nemoralia.spring.repositorio;

import com.nemoralia.spring.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de acceso a datos para la entidad Producto. Al extender
 * JpaRepository, Spring Data JPA genera automaticamente las operaciones
 * basicas de almacenamiento (guardar, consultar, actualizar, eliminar)
 * sin necesidad de implementarlas manualmente.
 *
 * @author Julian Andres Trujillo Morales
 */
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
