package com.nemoralia.mobile

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.nemoralia.mobile.data.ProductoRepositorio
import com.nemoralia.mobile.ui.ProductoAdapter
import kotlinx.coroutines.launch

/**
 * Módulo móvil "Catálogo de productos" de Nemoralia (GA8-220501096-AA2-EV02).
 * Consume el mismo backend NemoraliaAPI (Spring Boot) desarrollado en la
 * Guía 7, reutilizando la arquitectura de capas del proyecto:
 *  - Capa de presentación: MainActivity + ProductoAdapter (este módulo).
 *  - Capa de acceso a datos: ProductoRepositorio + ApiService (Retrofit).
 *  - Capa de servicio/backend: NemoraliaAPI (ya existente, Guía 7).
 */
class MainActivity : AppCompatActivity() {

    private val repositorio = ProductoRepositorio()
    private val adapter = ProductoAdapter()

    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var textEstado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerProductos)
        swipeRefresh = findViewById(R.id.swipeRefresh)
        textEstado = findViewById(R.id.textEstado)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        swipeRefresh.setOnRefreshListener { cargarProductos() }

        cargarProductos()
    }

    private fun cargarProductos() {
        swipeRefresh.isRefreshing = true
        textEstado.text = getString(R.string.estado_cargando)

        lifecycleScope.launch {
            val resultado = repositorio.listarProductos()
            swipeRefresh.isRefreshing = false

            resultado
                .onSuccess { productos ->
                    adapter.actualizarLista(productos)
                    textEstado.text = if (productos.isEmpty()) {
                        getString(R.string.estado_vacio)
                    } else {
                        getString(R.string.estado_ok, productos.size)
                    }
                }
                .onFailure { error ->
                    textEstado.text = getString(R.string.estado_error, error.message)
                }
        }
    }
}
