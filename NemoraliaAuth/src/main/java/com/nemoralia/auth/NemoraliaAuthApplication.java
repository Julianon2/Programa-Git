package com.nemoralia.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que arranca el servicio web de registro e inicio de
 * sesion de Nemoralia.
 *
 * @author Julian Andres Trujillo Morales
 */
@SpringBootApplication
public class NemoraliaAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(NemoraliaAuthApplication.class, args);
    }
}
