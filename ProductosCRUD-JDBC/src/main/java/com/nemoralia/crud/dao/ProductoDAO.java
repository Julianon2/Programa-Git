package com.nemoralia.crud.dao;

import com.nemoralia.crud.conexion.ConexionBD;
import com.nemoralia.crud.modelo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO (Data Access Object) encargado del CRUD de productos utilizando JDBC
 * sobre la base de datos nemoralia_db.
 *
 * @author Julian Andres Trujillo Morales
 */
public class ProductoDAO {

    /**
     * Inserta un nuevo producto en la base de datos.
     *
     * @param producto producto a insertar.
     * @return true si la insercion fue exitosa.
     */
    public boolean insertar(Producto producto) {
        String sql = "INSERT INTO producto (nombre, descripcion, precio, stock) VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, producto.getNombre());
            sentencia.setString(2, producto.getDescripcion());
            sentencia.setDouble(3, producto.getPrecio());
            sentencia.setInt(4, producto.getStock());

            return sentencia.executeUpdate() > 0;

        } catch (SQLException excepcion) {
            System.out.println("Error al insertar producto: " + excepcion.getMessage());
            return false;
        }
    }

    /**
     * Consulta todos los productos registrados.
     *
     * @return lista de productos.
     */
    public List<Producto> consultarTodos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT id_producto, nombre, descripcion, precio, stock FROM producto";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {
                productos.add(mapearProducto(resultado));
            }

        } catch (SQLException excepcion) {
            System.out.println("Error al consultar productos: " + excepcion.getMessage());
        }

        return productos;
    }

    /**
     * Consulta un producto por su identificador.
     *
     * @param idProducto identificador del producto.
     * @return producto encontrado o null si no existe.
     */
    public Producto consultarPorId(int idProducto) {
        String sql = "SELECT id_producto, nombre, descripcion, precio, stock FROM producto WHERE id_producto = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idProducto);

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    return mapearProducto(resultado);
                }
            }

        } catch (SQLException excepcion) {
            System.out.println("Error al consultar producto: " + excepcion.getMessage());
        }

        return null;
    }

    /**
     * Actualiza los datos de un producto existente.
     *
     * @param producto producto con los datos actualizados.
     * @return true si la actualizacion fue exitosa.
     */
    public boolean actualizar(Producto producto) {
        String sql = "UPDATE producto SET nombre = ?, descripcion = ?, precio = ?, stock = ? WHERE id_producto = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, producto.getNombre());
            sentencia.setString(2, producto.getDescripcion());
            sentencia.setDouble(3, producto.getPrecio());
            sentencia.setInt(4, producto.getStock());
            sentencia.setInt(5, producto.getIdProducto());

            return sentencia.executeUpdate() > 0;

        } catch (SQLException excepcion) {
            System.out.println("Error al actualizar producto: " + excepcion.getMessage());
            return false;
        }
    }

    /**
     * Elimina un producto de la base de datos.
     *
     * @param idProducto identificador del producto a eliminar.
     * @return true si la eliminacion fue exitosa.
     */
    public boolean eliminar(int idProducto) {
        String sql = "DELETE FROM producto WHERE id_producto = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idProducto);

            return sentencia.executeUpdate() > 0;

        } catch (SQLException excepcion) {
            System.out.println("Error al eliminar producto: " + excepcion.getMessage());
            return false;
        }
    }

    /**
     * Convierte una fila del ResultSet en un objeto Producto.
     *
     * @param resultado fila actual del ResultSet.
     * @return objeto Producto mapeado.
     * @throws SQLException si ocurre un error de lectura.
     */
    private Producto mapearProducto(ResultSet resultado) throws SQLException {
        return new Producto(
                resultado.getInt("id_producto"),
                resultado.getString("nombre"),
                resultado.getString("descripcion"),
                resultado.getDouble("precio"),
                resultado.getInt("stock")
        );
    }
}
