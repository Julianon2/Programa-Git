package com.nemoralia.mobile.data

import retrofit2.Response
import retrofit2.http.GET

/**
 * Contrato de acceso al backend NemoraliaAPI.
 * Consume el endpoint real `GET /api/productos` (ProductoControlador, Guía 7).
 */
interface ApiService {

    @GET("api/productos")
    suspend fun obtenerProductos(): Response<List<Producto>>
}
