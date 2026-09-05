package com.nemoralia.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que arranca la aplicacion Spring Boot del modulo de
 * productos de Nemoralia.
 *
 * @author Julian Andres Trujillo Morales
 */
@SpringBootApplication
public class NemoraliaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(NemoraliaSpringApplication.class, args);
    }
}
