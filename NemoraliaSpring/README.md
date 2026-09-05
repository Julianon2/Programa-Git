# NemoraliaSpring

**Evidencia:** GA7-220501096-AA3-EV01. Codificación de módulos del software stand-alone, web y móvil.
**Aprendiz:** Julián Andrés Trujillo Morales
**Proyecto formativo:** Nemoralia

---

## Introducción

Este módulo corresponde a la evidencia GA7-220501096-AA3-EV01, en la cual se codifica el módulo de productos del proyecto formativo Nemoralia utilizando el framework **Spring Boot**, aplicando el paradigma orientado a objetos y el estándar de codificación definido en la evidencia GA7-220501096-AA1-EV02.

A diferencia del módulo de la evidencia AA2-EV01 (JDBC puro, con sentencias SQL escritas a mano), este módulo integra el almacenamiento de datos mediante **Spring Data JPA**, que gestiona automáticamente la persistencia de la entidad `Producto` contra la misma base de datos `nemoralia_db` en MySQL.

## Objetivo

Codificar el módulo de productos de Nemoralia aplicando el framework Spring Boot, integrando el almacenamiento de datos mediante Spring Data JPA y exponiendo las operaciones CRUD como servicios REST, cumpliendo con el estándar de codificación definido para el proyecto.

---

## Descripción del módulo

API REST construida con Spring Boot que gestiona el catálogo de productos de Nemoralia. Utiliza Spring Data JPA para el mapeo objeto-relacional (ORM) sobre MySQL, eliminando la necesidad de escribir consultas SQL manualmente.

## Estructura del proyecto

```
NemoraliaSpring/
├── pom.xml                                     # Configuración Maven y dependencias de Spring Boot
├── src/main/resources/
│   └── application.properties                  # Configuración de conexión a MySQL y puerto del servidor
└── src/main/java/com/nemoralia/spring/
    ├── NemoraliaSpringApplication.java         # Clase principal (arranque de Spring Boot)
    ├── modelo/
    │   └── Producto.java                       # Entidad JPA (@Entity) mapeada a la tabla producto
    ├── repositorio/
    │   └── ProductoRepositorio.java            # Interfaz JpaRepository (CRUD automático)
    └── controlador/
        └── ProductoControlador.java            # Controlador REST (@RestController) con endpoints CRUD
```

## Framework aplicado

**Spring Boot 3.3.4** con los módulos:
- `spring-boot-starter-web` — para exponer los endpoints REST
- `spring-boot-starter-data-jpa` — para la integración de almacenamiento de datos (ORM con Hibernate)
- `mysql-connector-j` — driver de conexión a MySQL

## Endpoints disponibles

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/productos` | Consultar todos los productos |
| GET | `/api/productos/{id}` | Consultar un producto por id |
| POST | `/api/productos` | Registrar un nuevo producto |
| PUT | `/api/productos/{id}` | Actualizar un producto existente |
| DELETE | `/api/productos/{id}` | Eliminar un producto |

## Estándar de codificación aplicado

- **Clases e interfaces:** PascalCase (`Producto`, `ProductoRepositorio`, `ProductoControlador`)
- **Métodos y variables:** camelCase (`consultarTodos`, `productoRepositorio`)
- **Encapsulamiento:** atributos privados con getters y setters
- **Comentarios:** bloques Javadoc en clases y métodos explicando el propósito de cada componente

## Requisitos previos

1. Tener instalado el **JDK 17 o superior** (ya se cuenta con JDK 25 en este equipo).
2. Tener instalado **Apache Maven** (o usar el wrapper `mvnw` si se agrega al proyecto).
3. Tener **MySQL** corriendo con la base de datos `nemoralia_db` ya creada (la misma usada en la evidencia AA2-EV01).
4. Ajustar usuario, contraseña y puerto en `application.properties` si son distintos.

## Cómo ejecutar

**Opción 1 — Con Maven (línea de comandos):**
```bash
cd NemoraliaSpring
mvn spring-boot:run
```

**Opción 2 — Desde un IDE (Eclipse, IntelliJ, Spring Tool Suite):**
1. Importar el proyecto como "Existing Maven Project".
2. Ejecutar la clase `NemoraliaSpringApplication.java` como aplicación Java (Run As → Java Application o Spring Boot App).

La aplicación quedará disponible en `http://localhost:8081/api/productos`.

## Pruebas

Se puede probar cada endpoint con Postman o `curl`, por ejemplo:

```bash
# Consultar todos los productos
curl http://localhost:8081/api/productos

# Registrar un producto
curl -X POST http://localhost:8081/api/productos -H "Content-Type: application/json" -d "{\"nombre\":\"Bufanda Nemoralia\",\"descripcion\":\"Bufanda tejida edicion limitada\",\"precio\":45000,\"stock\":15}"
```

## Control de versiones

Este módulo forma parte del repositorio del proyecto formativo Nemoralia. Ver el archivo `ENLACE_REPOSITORIO.txt` en esta misma carpeta.
