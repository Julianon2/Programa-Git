# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Proyecto: Nemoralia

E-commerce colombiano con sede en Villavicencio, Meta. Vende productos con autenticación de usuarios y carrito de compras.

---

## Stack Tecnológico

### Frontend
- **React 18** + **Vite 6** (bundler con HMR)
- **React Router DOM 7** para navegación SPA
- **Tailwind CSS 3** con design system "Midnight Editorial" (colores, fuentes, bordes definidos en `tailwind.config.js`)
- **Fuentes:** Epilogue (títulos `font-headline`) + Manrope (cuerpo `font-body`) vía Google Fonts
- **Iconos:** Material Symbols Outlined vía Google Fonts
- **ESLint 9** con reglas React

### Backend (por implementar)
- **Node.js + Express** 
- API REST en `http://localhost:3000/api`
- Variable de entorno: `VITE_API_URL` en el frontend para apuntar al backend

---

## Comandos

### Frontend
```bash
cd frontend
npm install        # instalar dependencias
npm run dev        # servidor de desarrollo en http://localhost:5173
npm run build      # build de producción en frontend/dist/
npm run lint       # linter ESLint
npm run preview    # previsualizar build de producción
```

### Backend (cuando se implemente)
```bash
cd backend
npm install
npm run dev        # nodemon para desarrollo
npm start          # producción
```

---

## Arquitectura Frontend

```
frontend/src/
├── pages/          # Vistas completas (una por ruta)
├── components/     # Componentes reutilizables (Navbar, Footer)
├── context/        # Estado global — CartContext para el carrito
├── services/       # api.js centraliza todas las llamadas HTTP al backend
├── styles/         # CSS por página
├── App.jsx         # Router principal, importa Navbar y Footer
└── main.jsx        # Entry point, envuelve con BrowserRouter + CartProvider
```

### Rutas disponibles
| Ruta | Componente |
|------|-----------|
| `/` `/home` | Home |
| `/catalogo` | Catalogo |
| `/login` | Login |
| `/registro` | Registro |
| `/olvidaste` | Olvidaste |
| `/shopping_cart` | Carrito |

### Estado global
El carrito se maneja con `CartContext` (`src/context/CartContext.jsx`). Usar el hook `useCart()` para acceder a `{ cart, addToCart, removeFromCart, total }`.

### Servicios API
`src/services/api.js` expone tres módulos: `authService`, `productosService`, `carritoService`. Todos usan `fetch` apuntando a `VITE_API_URL` (default: `http://localhost:3000/api`).

---

## Arquitectura Backend (por implementar)

```
backend/src/
├── controllers/    # Lógica de negocio
├── models/         # Modelos de datos / ORM
├── routes/         # Definición de endpoints Express
└── middleware/     # Auth, validación, manejo de errores
```

---

## Fases de Implementación

### Fase 1 — Frontend base ✅
- Estructura de carpetas `frontend/` y `backend/`
- Componentes: Navbar, Footer, Login, Registro, Olvidaste, Carrito
- Routing con React Router DOM
- CartContext para estado global
- `services/api.js` preparado para conectar al backend

### Fase 2 — Diseño y UI ✅
- Diseño generado con Google Stitch (export en `stitch_nemoralia_dark_e_commerce_app/`)
- Tailwind CSS instalado y configurado con design system "Midnight Editorial"
- Home con hero, productos destacados, sección editorial y newsletter
- Catálogo con sidebar de filtros, grid de 6 productos con hover animado
- Carrito con layout de dos columnas, total con IVA y código de descuento
- Login, Registro y Olvidaste con nuevo diseño dark
- Navbar con indicador rojo en ruta activa, Footer rediseñado
- Imágenes de productos usando Unsplash (URLs estables)

### Fase 3 — Backend Node.js + Express
- Inicializar proyecto con `npm init` en `backend/`
- Instalar Express, cors, dotenv
- Implementar rutas: `/api/auth`, `/api/productos`, `/api/carrito`
- Conectar base de datos

### Fase 4 — Integración Frontend ↔ Backend
- Conectar formularios (Login, Registro) a `authService`
- Conectar Catalogo a `productosService.getAll()`
- Conectar Carrito a `carritoService`
- Manejo de tokens JWT para autenticación

### Fase 5 — Base de datos
- Definir modelos: Usuario, Producto, Carrito, Pedido
- Migraciones y datos de prueba

---

## Variables de Entorno

### Frontend (`frontend/.env`)
```
VITE_API_URL=http://localhost:3000/api
```

### Backend (`backend/.env`)
```
PORT=3000
DB_HOST=localhost
DB_NAME=nemoralia
JWT_SECRET=...
```
