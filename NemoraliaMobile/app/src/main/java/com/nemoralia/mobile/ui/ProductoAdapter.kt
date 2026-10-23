package com.nemoralia.mobile.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nemoralia.mobile.R
import com.nemoralia.mobile.data.Producto
import java.text.NumberFormat
import java.util.Locale

class ProductoAdapter(
    private val productos: MutableList<Producto> = mutableListOf()
) : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    private val formatoMoneda = NumberFormat.getCurrencyInstance(Locale("es", "CO"))

    fun actualizarLista(nuevaLista: List<Producto>) {
        productos.clear()
        productos.addAll(nuevaLista)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        holder.bind(productos[position], formatoMoneda)
    }

    override fun getItemCount(): Int = productos.size

    class ProductoViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
        private val nombre: TextView = itemView.findViewById(R.id.textNombreProducto)
        private val descripcion: TextView = itemView.findViewById(R.id.textDescripcionProducto)
        private val precioStock: TextView = itemView.findViewById(R.id.textPrecioStock)

        fun bind(producto: Producto, formatoMoneda: NumberFormat) {
            nombre.text = producto.nombre
            descripcion.text = producto.descripcion ?: ""
            precioStock.text = itemView.context.getString(
                R.string.formato_precio_stock,
                formatoMoneda.format(producto.precio),
                producto.stock
            )
        }
    }
}
