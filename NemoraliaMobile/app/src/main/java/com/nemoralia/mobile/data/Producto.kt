package com.nemoralia.mobile.data

/**
 * Modelo de datos del módulo móvil.
 * Refleja la entidad JPA `Producto` de NemoraliaAPI (Guía 7) para que el
 * mapeo JSON <-> objeto sea directo con el backend real.
 */
data class Producto(
    val idProducto: Int?,
    val nombre: String,
    val descripcion: String?,
    val precio: Double,
    val stock: Int
)
