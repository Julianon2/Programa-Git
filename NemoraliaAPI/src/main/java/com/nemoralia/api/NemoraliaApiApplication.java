package com.nemoralia.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que arranca la API REST completa del proyecto
 * Nemoralia: productos, autenticacion y carrito de compras.
 *
 * @author Julian Andres Trujillo Morales
 */
@SpringBootApplication
public class NemoraliaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NemoraliaApiApplication.class, args);
    }
}
