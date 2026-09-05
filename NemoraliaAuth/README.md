# NemoraliaAuth

**Evidencia:** GA7-220501096-AA5-EV01. Diseño y desarrollo de servicios web - caso.
**Aprendiz:** Julián Andrés Trujillo Morales
**Proyecto formativo:** Nemoralia

---

## Introducción

Este módulo corresponde a la evidencia GA7-220501096-AA5-EV01, en la cual se diseña y codifica un servicio web para el caso planteado en el componente formativo "Construcción API": un servicio de registro e inicio de sesión que recibe un usuario y una contraseña, respondiendo con un mensaje de autenticación satisfactoria si las credenciales son correctas, o con un mensaje de error en caso contrario.

## Objetivo

Diseñar y codificar servicios web para el registro y el inicio de sesión de usuarios de Nemoralia, aplicando validaciones de verificación sobre los datos recibidos.

---

## Descripción del servicio

API REST construida con **Spring Boot** que expone dos servicios:

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/api/auth/registro` | Registra un nuevo usuario (nombreUsuario + contraseña) |
| POST | `/api/auth/login` | Valida el inicio de sesión de un usuario existente |

## Validaciones implementadas

- **Campos vacíos:** si el usuario o la contraseña llegan vacíos o nulos, se responde `400 Bad Request`.
- **Usuario duplicado (registro):** si el nombre de usuario ya existe, se responde `409 Conflict`.
- **Autenticación exitosa (login):** si el usuario existe y la contraseña coincide, se responde `200 OK` con el mensaje "Autenticacion satisfactoria."
- **Autenticación fallida (login):** si el usuario no existe o la contraseña no coincide, se responde `401 Unauthorized` con el mensaje "Error en la autenticacion."

## Ejemplos de uso (Postman)

**Registro:**
```
POST http://localhost:8082/api/auth/registro
Body (JSON):
{
  "nombreUsuario": "julian.trujillo",
  "contrasena": "Nemoralia2026"
}
```

**Inicio de sesión (correcto):**
```
POST http://localhost:8082/api/auth/login
Body (JSON):
{
  "nombreUsuario": "julian.trujillo",
  "contrasena": "Nemoralia2026"
}
```

**Inicio de sesión (incorrecto):**
```
POST http://localhost:8082/api/auth/login
Body (JSON):
{
  "nombreUsuario": "julian.trujillo",
  "contrasena": "clave_incorrecta"
}
```

## Estándar de codificación aplicado

- **Clases:** PascalCase (`Usuario`, `CredencialesDTO`, `AutenticacionControlador`)
- **Métodos y variables:** camelCase (`iniciarSesion`, `nombreUsuario`, `autenticacionCorrecta`)
- **Encapsulamiento:** atributos privados con getters y setters
- **Comentarios:** bloques Javadoc en clases y métodos

## Requisitos previos

1. JDK 17 o superior.
2. MySQL corriendo con la base de datos `nemoralia_db` (la misma usada en AA2-EV01 y AA3-EV01).
3. Importar como proyecto Maven en Eclipse.

## Cómo ejecutar

1. Importar en Eclipse: **File → Import → Maven → Existing Maven Projects**.
2. Ejecutar `NemoraliaAuthApplication.java` como **Java Application**.
3. El servicio queda disponible en `http://localhost:8082/api/auth`.

## Control de versiones

Este módulo forma parte del repositorio del proyecto formativo Nemoralia. Ver el archivo `ENLACE_REPOSITORIO.txt` en esta misma carpeta.
