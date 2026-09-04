const BASE_URL = import.meta.env.VITE_API_URL || 'http://localhost:3000/api';

async function request(endpoint, options = {}) {
  const response = await fetch(`${BASE_URL}${endpoint}`, {
    headers: { 'Content-Type': 'application/json' },
    ...options,
  });
  if (!response.ok) throw new Error(`Error ${response.status}`);
  return response.json();
}

export const authService = {
  login: (email, password) =>
    request('/auth/login', { method: 'POST', body: JSON.stringify({ email, password }) }),
  registro: (data) =>
    request('/auth/registro', { method: 'POST', body: JSON.stringify(data) }),
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
