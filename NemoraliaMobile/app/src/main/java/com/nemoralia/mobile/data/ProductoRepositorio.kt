package com.nemoralia.mobile.data

/**
 * Capa de repositorio: aísla a la capa de presentación (MainActivity) del
 * detalle de la capa de red (Retrofit). Patrón Repository.
 */
class ProductoRepositorio(
    private val apiService: ApiService = RetrofitClient.apiService
) {

    suspend fun listarProductos(): Result<List<Producto>> {
        return try {
            val respuesta = apiService.obtenerProductos()
            if (respuesta.isSuccessful) {
                Result.success(respuesta.body().orEmpty())
            } else {
                Result.failure(Exception("Error del servidor: ${respuesta.code()}"))
            }
        } catch (excepcion: Exception) {
            Result.failure(excepcion)
        }
    }
}
