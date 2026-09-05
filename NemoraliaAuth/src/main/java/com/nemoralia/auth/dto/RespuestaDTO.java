package com.nemoralia.auth.dto;

/**
 * Objeto de transferencia de datos (DTO) que representa la respuesta
 * estandar del servicio de autenticacion.
 *
 * @author Julian Andres Trujillo Morales
 */
public class RespuestaDTO {

    private String mensaje;

    public RespuestaDTO() {
    }

    public RespuestaDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
