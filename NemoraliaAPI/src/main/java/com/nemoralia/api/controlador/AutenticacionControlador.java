package com.nemoralia.api.controlador;

import com.nemoralia.api.dto.CredencialesDTO;
import com.nemoralia.api.dto.RespuestaDTO;
import com.nemoralia.api.modelo.Usuario;
import com.nemoralia.api.repositorio.UsuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Controlador REST de autenticacion (registro e inicio de sesion) de
 * Nemoralia.
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

    @PostMapping("/registro")
    public ResponseEntity<RespuestaDTO> registrar(@RequestBody CredencialesDTO credenciales) {

        if (credenciales.getNombreUsuario() == null || credenciales.getNombreUsuario().isBlank()
                || credenciales.getContrasena() == null || credenciales.getContrasena().isBlank()) {
            return ResponseEntity.badRequest()
                    .body(new RespuestaDTO("El usuario y la contrasena son obligatorios."));
        }

        if (usuarioRepositorio.findByNombreUsuario(credenciales.getNombreUsuario()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new RespuestaDTO("El usuario ya se encuentra registrado."));
        }

        usuarioRepositorio.save(new Usuario(credenciales.getNombreUsuario(), credenciales.getContrasena()));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new RespuestaDTO("Registro exitoso."));
    }

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
