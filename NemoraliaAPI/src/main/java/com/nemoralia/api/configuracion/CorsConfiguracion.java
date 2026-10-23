package com.nemoralia.api.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Permite que el front-end publicado en Vercel y el servidor de desarrollo
 * local consuman la API desde el navegador (CORS).
 *
 * Ajuste GA11-220501098-AA3-EV01.
 *
 * @author Julian Andres Trujillo Morales
 */
@Configuration
public class CorsConfiguracion {

    @Bean
    public WebMvcConfigurer configuradorCors() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registro) {
                registro.addMapping("/api/**")
                        .allowedOrigins(
                                "https://programa-git-azure.vercel.app",
                                "http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}
