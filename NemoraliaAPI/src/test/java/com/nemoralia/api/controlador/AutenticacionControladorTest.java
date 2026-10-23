package com.nemoralia.api.controlador;

import com.nemoralia.api.dto.CredencialesDTO;
import com.nemoralia.api.dto.RespuestaDTO;
import com.nemoralia.api.modelo.Usuario;
import com.nemoralia.api.repositorio.UsuarioRepositorio;
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
 * Pruebas unitarias del controlador de autenticacion.
 * Ajuste GA11-220501098-AA3-EV01.
 *
 * @author Julian Andres Trujillo Morales
 */
class AutenticacionControladorTest {

    private UsuarioRepositorio repositorio;
    private AutenticacionControlador controlador;

    @BeforeEach
    void preparar() {
        repositorio = mock(UsuarioRepositorio.class);
        controlador = new AutenticacionControlador(repositorio);
    }

    private CredencialesDTO credenciales(String usuario, String contrasena) {
        CredencialesDTO dto = new CredencialesDTO();
        dto.setNombreUsuario(usuario);
        dto.setContrasena(contrasena);
        return dto;
    }

    @Test
    @DisplayName("Registro exitoso de un usuario nuevo")
    void registraUsuarioNuevo() {
        when(repositorio.findByNombreUsuario("julian@nemoralia.com")).thenReturn(Optional.empty());

        ResponseEntity<RespuestaDTO> respuesta = controlador.registrar(credenciales("julian@nemoralia.com", "Clave2026*"));

        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());
        assertEquals("Registro exitoso.", respuesta.getBody().getMensaje());
        verify(repositorio).save(any(Usuario.class));
    }

    @Test
    @DisplayName("Rechaza el registro de un usuario duplicado")
    void rechazaUsuarioDuplicado() {
        when(repositorio.findByNombreUsuario("julian@nemoralia.com"))
                .thenReturn(Optional.of(new Usuario("julian@nemoralia.com", "Clave2026*")));

        ResponseEntity<RespuestaDTO> respuesta = controlador.registrar(credenciales("julian@nemoralia.com", "Clave2026*"));

        assertEquals(HttpStatus.CONFLICT, respuesta.getStatusCode());
        verify(repositorio, never()).save(any(Usuario.class));
    }

    @Test
    @DisplayName("Rechaza el registro con campos vacios")
    void rechazaRegistroVacio() {
        ResponseEntity<RespuestaDTO> respuesta = controlador.registrar(credenciales("", ""));

        assertEquals(HttpStatus.BAD_REQUEST, respuesta.getStatusCode());
        verify(repositorio, never()).save(any(Usuario.class));
    }

    @Test
    @DisplayName("Inicio de sesion con credenciales correctas")
    void iniciaSesionCorrecta() {
        when(repositorio.findByNombreUsuario("julian@nemoralia.com"))
                .thenReturn(Optional.of(new Usuario("julian@nemoralia.com", "Clave2026*")));

        ResponseEntity<RespuestaDTO> respuesta = controlador.iniciarSesion(credenciales("julian@nemoralia.com", "Clave2026*"));

        assertEquals(HttpStatus.OK, respuesta.getStatusCode());
        assertEquals("Autenticacion satisfactoria.", respuesta.getBody().getMensaje());
    }

    @Test
    @DisplayName("Rechaza el inicio de sesion con contrasena incorrecta")
    void rechazaContrasenaIncorrecta() {
        when(repositorio.findByNombreUsuario("julian@nemoralia.com"))
                .thenReturn(Optional.of(new Usuario("julian@nemoralia.com", "Clave2026*")));

        ResponseEntity<RespuestaDTO> respuesta = controlador.iniciarSesion(credenciales("julian@nemoralia.com", "otra"));

        assertEquals(HttpStatus.UNAUTHORIZED, respuesta.getStatusCode());
    }
}
