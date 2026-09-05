<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.nemoralia.web.modelo.Producto" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Nemoralia - Listado de productos</title>
</head>
<body>
    <h1>Listado de productos registrados</h1>

    <%
        // Elemento JSP: scriptlet que obtiene la lista enviada desde el Servlet via GET
        List<Producto> productos = (List<Producto>) request.getAttribute("productos");
    %>

    <table border="1" cellpadding="5">
        <tr>
            <th>Nombre</th>
            <th>Descripcion</th>
            <th>Precio</th>
            <th>Stock</th>
        </tr>

        <% for (Producto producto : productos) { %>
        <tr>
            <td><%= producto.getNombre() %></td>
            <td><%= producto.getDescripcion() %></td>
            <td><%= producto.getPrecio() %></td>
            <td><%= producto.getStock() %></td>
        </tr>
        <% } %>
    </table>

    <br>
    <a href="/index.html">Volver al formulario</a>
</body>
</html>
