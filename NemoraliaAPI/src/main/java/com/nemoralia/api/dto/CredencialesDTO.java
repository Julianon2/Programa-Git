package com.nemoralia.api.dto;

/**
 * DTO que representa las credenciales enviadas para registro o login.
 *
 * @author Julian Andres Trujillo Morales
 */
public class CredencialesDTO {

    private String nombreUsuario;
    private String contrasena;

    public CredencialesDTO() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
