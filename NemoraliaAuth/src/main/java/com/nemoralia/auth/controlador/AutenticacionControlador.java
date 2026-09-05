package com.nemoralia.auth.controlador;

import com.nemoralia.auth.dto.CredencialesDTO;
import com.nemoralia.auth.dto.RespuestaDTO;
import com.nemoralia.auth.modelo.Usuario;
import com.nemoralia.auth.repositorio.UsuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Controlador REST que expone los servicios web de registro e inicio
 * de sesion de Nemoralia. Corresponde al caso planteado en la evidencia
 * GA7-220501096-AA5-EV01: un servicio que recibe usuario y contrasena,
 * validando la autenticacion y respondiendo con un mensaje de exito o
 * de error segun corresponda.
 *
 * @author Julian Andres Trujillo Morales
 */
@RestController
@RequestMapping("/api/auth")
public class AutenticacionControlador {

    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public AutenticacionControlador(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    /**
     * Registra un nuevo usuario, validando que el nombre de usuario y la
     * contrasena no esten vacios y que el nombre de usuario no exista
     * previamente.
     */
    @PostMapping("/registro")
    public ResponseEntity<RespuestaDTO> registrar(@RequestBody CredencialesDTO credenciales) {

        if (credenciales.getNombreUsuario() == null || credenciales.getNombreUsuario().isBlank()
                || credenciales.getContrasena() == null || credenciales.getContrasena().isBlank()) {
            return ResponseEntity.badRequest()
                    .body(new RespuestaDTO("El usuario y la contrasena son obligatorios."));
        }

        Optional<Usuario> usuarioExistente = usuarioRepositorio.findByNombreUsuario(credenciales.getNombreUsuario());

        if (usuarioExistente.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new RespuestaDTO("El usuario ya se encuentra registrado."));
        }

        Usuario nuevoUsuario = new Usuario(credenciales.getNombreUsuario(), credenciales.getContrasena());
        usuarioRepositorio.save(nuevoUsuario);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new RespuestaDTO("Registro exitoso."));
    }

    /**
     * Valida el inicio de sesion comparando el usuario y la contrasena
     * recibidos contra los almacenados en la base de datos.
     */
    @PostMapping("/login")
    public ResponseEntity<RespuestaDTO> iniciarSesion(@RequestBody CredencialesDTO credenciales) {

        if (credenciales.getNombreUsuario() == null || credenciales.getNombreUsuario().isBlank()
                || credenciales.getContrasena() == null || credenciales.getContrasena().isBlank()) {
            return ResponseEntity.badRequest()
                    .body(new RespuestaDTO("El usuario y la contrasena son obligatorios."));
        }

        Optional<Usuario> usuario = usuarioRepositorio.findByNombreUsuario(credenciales.getNombreUsuario());

        boolean autenticacionCorrecta = usuario.isPresent()
                && usuario.get().getContrasena().equals(credenciales.getContrasena());

        if (autenticacionCorrecta) {
            return ResponseEntity.ok(new RespuestaDTO("Autenticacion satisfactoria."));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new RespuestaDTO("Error en la autenticacion."));
    }
}
