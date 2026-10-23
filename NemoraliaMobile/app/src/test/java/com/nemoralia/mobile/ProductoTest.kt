package com.nemoralia.mobile

import com.nemoralia.mobile.data.Producto
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Prueba unitaria del módulo (requisito de la evidencia GA8-220501096-AA2-EV02).
 * Verifica el mapeo correcto del modelo que consume el JSON de NemoraliaAPI.
 */
class ProductoTest {

    @Test
    fun `producto se construye con los campos esperados`() {
        val producto = Producto(
            idProducto = 1,
            nombre = "Vela aromática lavanda",
            descripcion = "Vela de soya 200g",
            precio = 25000.0,
            stock = 10
        )

        assertEquals(1, producto.idProducto)
        assertEquals("Vela aromática lavanda", producto.nombre)
        assertEquals(25000.0, producto.precio, 0.0)
        assertEquals(10, producto.stock)
    }
}
