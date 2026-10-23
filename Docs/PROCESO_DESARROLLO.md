# Proceso de desarrollo de Nemoralia

Ajustado en la evidencia GA11-220501098-AA3-EV01.
Autor: Julián Andrés Trujillo Morales.

## Metodología

Desarrollo incremental (un módulo por incremento), con control de versiones en Git.

## Secuencia de trabajo para cada cambio

1. **Registrar** el cambio o defecto (código, descripción, componente afectado y criterio de aceptación).
2. **Crear una rama** desde `master` con el prefijo del tipo de cambio:
   - `feature/<nombre>` para funcionalidades nuevas.
   - `fix/<nombre>` para correcciones.
3. **Codificar** el cambio y su prueba unitaria.
4. **Ejecutar las pruebas locales**:
   - API: `mvn test` (pruebas unitarias JUnit 5 + Mockito).
   - Móvil: `ProductoTest` en Android Studio.
   - Front-end: `npm run build` sin errores.
5. **Ejecutar la regresión de la API** con la colección `pruebas/Nemoralia-API.postman_collection.json`
   (Postman → Run collection) sobre `http://localhost:8083`.
6. **Hacer commit** con un mensaje descriptivo y **subir la rama** (`git push`).
7. **Integrar** la rama a `master` solo si todas las pruebas pasan.
8. **Verificar en producción** (Vercel y Render) repitiendo la colección de Postman con
   `baseUrl = https://nemoralia-api.onrender.com`.
9. **Actualizar la documentación** (manual técnico, manual de usuario) cuando el cambio la afecte.

## Componentes del repositorio

| Carpeta | Componente |
|---|---|
| `frontend/` | Sitio web React (Vercel) |
| `NemoraliaAPI/` | API REST Spring Boot (Render) |
| `NemoraliaMobile/` | Aplicación móvil Android |
| `pruebas/` | Colección de pruebas de Postman |
