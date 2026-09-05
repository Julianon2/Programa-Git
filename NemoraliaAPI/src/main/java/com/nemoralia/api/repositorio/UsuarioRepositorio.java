package com.nemoralia.api.repositorio;

import com.nemoralia.api.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio de acceso a datos para la entidad Usuario.
 *
 * @author Julian Andres Trujillo Morales
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    /**
     * Busca un usuario por su nombre de usuario.
     */
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}
