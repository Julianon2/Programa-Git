package com.nemoralia.crud.app;

import com.nemoralia.crud.dao.ProductoDAO;
import com.nemoralia.crud.modelo.Producto;

import java.util.List;
import java.util.Scanner;

/**
 * Aplicacion de consola que permite probar el CRUD de productos del
 * proyecto Nemoralia utilizando JDBC.
 *
 * @author Julian Andres Trujillo Morales
 */
public class AppPrincipal {

    private static final ProductoDAO productoDAO = new ProductoDAO();
    private static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    insertarProducto();
                    break;
                case 2:
                    consultarProductos();
                    break;
                case 3:
                    actualizarProducto();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 5);

        entrada.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== MODULO DE PRODUCTOS - NEMORALIA (JDBC) =====");
        System.out.println("1. Insertar producto");
        System.out.println("2. Consultar productos");
        System.out.println("3. Actualizar producto");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Salir");
    }

    private static void insertarProducto() {
        System.out.println("\n-- Insertar producto --");
        String nombre = leerTexto("Nombre: ");
        String descripcion = leerTexto("Descripcion: ");
        double precio = leerDecimal("Precio: ");
        int stock = leerEntero("Stock: ");

        Producto producto = new Producto(nombre, descripcion, precio, stock);
        boolean exito = productoDAO.insertar(producto);

        System.out.println(exito ? "Producto insertado correctamente." : "No se pudo insertar el producto.");
    }

    private static void consultarProductos() {
        System.out.println("\n-- Listado de productos --");
        List<Producto> productos = productoDAO.consultarTodos();

        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    private static void actualizarProducto() {
        System.out.println("\n-- Actualizar producto --");
        int idProducto = leerEntero("Id del producto a actualizar: ");
        Producto producto = productoDAO.consultarPorId(idProducto);

        if (producto == null) {
            System.out.println("No existe un producto con ese id.");
            return;
        }

        producto.setNombre(leerTexto("Nuevo nombre: "));
        producto.setDescripcion(leerTexto("Nueva descripcion: "));
        producto.setPrecio(leerDecimal("Nuevo precio: "));
        producto.setStock(leerEntero("Nuevo stock: "));

        boolean exito = productoDAO.actualizar(producto);
        System.out.println(exito ? "Producto actualizado correctamente." : "No se pudo actualizar el producto.");
    }

    private static void eliminarProducto() {
        System.out.println("\n-- Eliminar producto --");
        int idProducto = leerEntero("Id del producto a eliminar: ");

        boolean exito = productoDAO.eliminar(idProducto);
        System.out.println(exito ? "Producto eliminado correctamente." : "No se pudo eliminar el producto.");
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return entrada.nextLine();
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        int valor = Integer.parseInt(entrada.nextLine().trim());
        return valor;
    }

    private static double leerDecimal(String mensaje) {
        System.out.print(mensaje);
        double valor = Double.parseDouble(entrada.nextLine().trim());
        return valor;
    }
}
