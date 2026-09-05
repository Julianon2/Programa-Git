package com.nemoralia.web.servlet;

import com.nemoralia.web.modelo.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet que gestiona el registro de productos del modulo web de
 * Nemoralia, recibiendo los parametros del formulario HTML mediante
 * los metodos GET y POST.
 *
 * @author Julian Andres Trujillo Morales
 */
@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

    private static final List<Producto> productosRegistrados = new ArrayList<>();

    /**
     * Atiende las peticiones GET: muestra el formulario cargado desde la
     * pagina index.html y, si llega el parametro accion=listar, redirige
     * el listado hacia la vista JSP.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("listar".equals(accion)) {
            request.setAttribute("productos", productosRegistrados);
            request.getRequestDispatcher("/jsp/listaProductos.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/index.html").forward(request, response);
        }
    }

    /**
     * Atiende las peticiones POST enviadas desde el formulario HTML,
     * procesa los datos del producto y los envia a la vista JSP de
     * resultado.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        Producto producto = new Producto(nombre, descripcion, precio, stock);
        productosRegistrados.add(producto);

        request.setAttribute("producto", producto);
        request.getRequestDispatcher("/jsp/resultado.jsp").forward(request, response);
    }
}
