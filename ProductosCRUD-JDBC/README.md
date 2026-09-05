# ProductosCRUD-JDBC

**Evidencia:** GA7-220501096-AA2-EV01. Codificación de módulos del software.
**Aprendiz:** Julián Andrés Trujillo Morales
**Proyecto formativo:** Nemoralia

---

## Introducción

Este módulo corresponde a la evidencia GA7-220501096-AA2-EV01, en la cual se codifica un componente del proyecto formativo Nemoralia que realiza conexiones a bases de datos por medio de JDBC, aplicando el estándar de codificación definido previamente en la evidencia GA7-220501096-AA1-EV02 (nomenclatura PascalCase para clases, camelCase para métodos y variables, documentación con Javadoc y encapsulamiento mediante getters y setters).

## Objetivo

Codificar el módulo de gestión de productos del proyecto Nemoralia, implementando operaciones de inserción, consulta, actualización y eliminación (CRUD) sobre una base de datos relacional, utilizando JDBC como mecanismo de conexión.

---

## Descripción del módulo

Aplicación de consola en Java que gestiona el catálogo de productos de Nemoralia mediante JDBC y MySQL, aplicando el patrón DAO (Data Access Object) para separar el acceso a datos de la lógica de la aplicación.

## Estructura del proyecto

```
ProductosCRUD-JDBC/
├── sql/
│   └── nemoralia_productos.sql       # Script de creación de base de datos y tabla producto
├── lib/
│   └── mysql-connector-j-x.x.x.jar   # Driver JDBC de MySQL (descargar aparte)
├── src/main/java/com/nemoralia/crud/
│   ├── modelo/
│   │   └── Producto.java             # Clase modelo (POJO)
│   ├── conexion/
│   │   └── ConexionBD.java           # Clase de conexión JDBC
│   ├── dao/
│   │   └── ProductoDAO.java          # CRUD: insertar, consultarTodos, consultarPorId, actualizar, eliminar
│   └── app/
│       └── AppPrincipal.java         # Menú de consola para probar el CRUD
```

## Estándar de codificación aplicado

- **Clases:** PascalCase (`Producto`, `ConexionBD`, `ProductoDAO`, `AppPrincipal`)
- **Métodos y variables:** camelCase (`consultarTodos`, `idProducto`, `obtenerConexion`)
- **Constantes:** MAYÚSCULAS_CON_GUIONES (`URL`, `USUARIO`, `CONTRASENA`)
- **Encapsulamiento:** atributos privados con getters y setters
- **Comentarios:** bloques Javadoc en clases y métodos públicos

## Requisitos previos

1. Tener instalado **MySQL Server** (o MariaDB).
2. Descargar el **driver JDBC de MySQL** (`mysql-connector-j`) y colocarlo en la carpeta `lib/`.
   - Descarga oficial: https://dev.mysql.com/downloads/connector/j/
3. Ejecutar el script `sql/nemoralia_productos.sql` en MySQL para crear la base de datos `nemoralia_db` y la tabla `producto`.
4. Ajustar usuario y contraseña en `ConexionBD.java` si son distintos a `root` / vacío.

## Cómo compilar y ejecutar (línea de comandos)

Desde la carpeta `ProductosCRUD-JDBC/`:

```bash
# Compilar
javac -d bin -cp "lib/*" src/main/java/com/nemoralia/crud/modelo/Producto.java src/main/java/com/nemoralia/crud/conexion/ConexionBD.java src/main/java/com/nemoralia/crud/dao/ProductoDAO.java src/main/java/com/nemoralia/crud/app/AppPrincipal.java

# Ejecutar (Windows)
java -cp "bin;lib/*" com.nemoralia.crud.app.AppPrincipal

# Ejecutar (Linux/Mac)
java -cp "bin:lib/*" com.nemoralia.crud.app.AppPrincipal
```

> También se puede importar el proyecto en Eclipse o NetBeans como proyecto Java estándar, agregando el jar del conector MySQL al Build Path.

## Funcionalidades

- **Insertar** un nuevo producto.
- **Consultar** todos los productos o uno por id.
- **Actualizar** los datos de un producto existente.
- **Eliminar** un producto por id.

## Control de versiones

Este módulo forma parte del repositorio del proyecto formativo Nemoralia. Ver el archivo `ENLACE_REPOSITORIO.txt` en esta misma carpeta.
