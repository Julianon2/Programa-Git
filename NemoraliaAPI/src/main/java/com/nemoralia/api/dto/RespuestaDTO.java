package com.nemoralia.api.dto;

/**
 * DTO de respuesta estandar para mensajes simples de la API.
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
