// URL de NemoraliaAPI. En producción se usa la API desplegada en Render.
const BASE_URL = import.meta.env.VITE_API_URL || 'https://nemoralia-api.onrender.com/api';

async function request(endpoint, options = {}) {
  const response = await fetch(`${BASE_URL}${endpoint}`, {
    headers: { 'Content-Type': 'application/json' },
    ...options,
  });
  const data = await response.json().catch(() => ({}));
  if (!response.ok) throw new Error(data.mensaje || `Error ${response.status}`);
  return data;
}

export const authService = {
  login: (email, password) =>
    request('/auth/login', { method: 'POST', body: JSON.stringify({ nombreUsuario: email, contrasena: password }) }),
  registro: (data) =>
    request('/auth/registro', { method: 'POST', body: JSON.stringify({ nombreUsuario: data.email, contrasena: data.password }) }),
  recuperar: (email) =>
    request('/auth/recuperar', { method: 'POST', body: JSON.stringify({ email }) }),
};

export const productosService = {
  getAll: () => request('/productos'),
  getById: (id) => request(`/productos/${id}`),
};

export const carritoService = {
  get: () => request('/carrito'),
  agregar: (productoId) =>
    request('/carrito', { method: 'POST', body: JSON.stringify({ productoId }) }),
  eliminar: (productoId) =>
    request(`/carrito/${productoId}`, { method: 'DELETE' }),
};
