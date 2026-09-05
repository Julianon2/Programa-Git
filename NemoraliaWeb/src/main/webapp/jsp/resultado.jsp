<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.nemoralia.web.modelo.Producto" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Nemoralia - Producto registrado</title>
</head>
<body>
    <h1>Producto registrado correctamente</h1>

    <%
        // Elemento JSP: scriptlet que obtiene el objeto enviado desde el Servlet via POST
        Producto producto = (Producto) request.getAttribute("producto");
    %>

    <ul>
        <li>Nombre: <%= producto.getNombre() %></li>
        <li>Descripcion: <%= producto.getDescripcion() %></li>
        <li>Precio: <%= producto.getPrecio() %></li>
        <li>Stock: <%= producto.getStock() %></li>
    </ul>

    <a href="/index.html">Registrar otro producto</a> |
    <a href="/ProductoServlet?accion=listar">Ver listado completo</a>
</body>
</html>
