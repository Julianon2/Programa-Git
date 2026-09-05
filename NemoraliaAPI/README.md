# NemoraliaAPI

**Evidencia:** GA7-220501096-AA5-EV03. Diseño y desarrollo de servicios web – proyecto.
**Aprendiz:** Julián Andrés Trujillo Morales
**Proyecto formativo:** Nemoralia

---

## Introducción

Esta evidencia corresponde al diseño y desarrollo de los servicios web completos del proyecto formativo Nemoralia, integrando en una sola API REST los tres módulos funcionales requeridos por el e-commerce: gestión de productos, autenticación de usuarios (registro e inicio de sesión) y carrito de compras.

## Objetivo

Diseñar y codificar la API REST completa del proyecto Nemoralia, cumpliendo con las necesidades funcionales del software (catálogo de productos, autenticación y carrito de compras), aplicando validaciones de verificación en cada servicio.

---

## Descripción del proyecto

API REST construida con **Spring Boot** y **Spring Data JPA**, que integra los tres módulos del e-commerce Nemoralia en un único servicio.

## Servicios / Endpoints

### Módulo de Productos
| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/productos` | Consultar todos los productos |
| GET | `/api/productos/{id}` | Consultar un producto por id |
| POST | `/api/productos` | Registrar un nuevo producto |
| PUT | `/api/productos/{id}` | Actualizar un producto |
| DELETE | `/api/productos/{id}` | Eliminar un producto |

### Módulo de Autenticación
| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/api/auth/registro` | Registrar un nuevo usuario |
| POST | `/api/auth/login` | Iniciar sesión |

### Módulo de Carrito de Compras
| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/carrito/{idUsuario}` | Consultar el carrito de un usuario |
| POST | `/api/carrito` | Agregar un producto al carrito |
| DELETE | `/api/carrito/{idItem}` | Eliminar un item del carrito |

Ver también el archivo `ENDPOINTS.txt` en esta misma carpeta.

## Validaciones implementadas

- **Autenticación:** campos vacíos (`400`), usuario duplicado (`409`), credenciales incorrectas (`401`).
- **Carrito:** cantidad menor o igual a cero (`400`), producto inexistente (`404`), stock insuficiente (`400`).
- **Productos:** id inexistente en consultar/actualizar/eliminar (`404`).

## Estructura del proyecto

```
NemoraliaAPI/
├── pom.xml
├── src/main/resources/application.properties
└── src/main/java/com/nemoralia/api/
    ├── NemoraliaApiApplication.java
    ├── modelo/          # Producto, Usuario, ItemCarrito (entidades JPA)
    ├── repositorio/     # ProductoRepositorio, UsuarioRepositorio, ItemCarritoRepositorio
    ├── dto/             # CredencialesDTO, RespuestaDTO
    └── controlador/     # ProductoControlador, AutenticacionControlador, CarritoControlador
```

## Estándar de codificación aplicado

- **Clases:** PascalCase
- **Métodos y variables:** camelCase
- **Encapsulamiento:** atributos privados con getters y setters
- **Comentarios:** Javadoc en clases y métodos

## Requisitos previos

1. JDK 17 o superior.
2. MySQL con la base de datos `nemoralia_db` ya creada.

## Cómo ejecutar

1. Importar en Eclipse: **File → Import → Maven → Existing Maven Projects**.
2. Ejecutar `NemoraliaApiApplication.java` como **Java Application**.
3. La API queda disponible en `http://localhost:8083`.

## Control de versiones

Este módulo forma parte del repositorio del proyecto formativo Nemoralia. Ver el archivo `ENLACE_REPOSITORIO.txt` en esta misma carpeta.
