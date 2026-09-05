package com.nemoralia.crud.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Gestiona la conexion a la base de datos MySQL del proyecto Nemoralia
 * utilizando JDBC.
 *
 * @author Julian Andres Trujillo Morales
 */
public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3307/nemoralia_db?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "123456";

    /**
     * Abre y retorna una conexion JDBC hacia la base de datos nemoralia_db.
     *
     * @return conexion activa hacia la base de datos.
     * @throws SQLException si ocurre un error al establecer la conexion.
     */
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}
