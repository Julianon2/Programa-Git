import React from 'react';
import { Link } from 'react-router-dom';
import { useCart } from '../context/CartContext';

function Carrito() {
  const { cart, removeFromCart, total } = useCart();
  const envio = 4.50;
  const iva = total * 0.19;

  return (
    <div className="bg-surface text-on-surface antialiased">
      <main className="pt-40 pb-24 min-h-screen px-8 max-w-screen-2xl mx-auto">
        <div className="mb-16">
          <h1 className="text-6xl font-headline font-extrabold tracking-tighter mb-4">
            Cesta de <span className="text-primary-container">Selección</span>
          </h1>
          <p className="text-on-surface-variant font-label tracking-widest uppercase text-xs">Tu selección curada.</p>
        </div>
        <div className="grid grid-cols-1 lg:grid-cols-12 gap-12 items-start">
          <div className="lg:col-span-8 space-y-8">
            {cart.length === 0 ? (
              <div className="text-center py-24">
                <span className="material-symbols-outlined text-6xl text-on-surface-variant mb-4 block">shopping_bag</span>
                <p className="text-on-surface-variant font-body text-lg mb-6">Tu carrito está vacío</p>
                <Link to="/catalogo" className="inline-flex items-center gap-2 bg-primary-container text-on-primary-container px-8 py-4 rounded-lg font-headline font-bold uppercase tracking-widest text-sm transition-all hover:bg-secondary-container active:scale-95">
                  Ver Catálogo
                </Link>
              </div>
            ) : (
              cart.map((product, index) => (
                <div key={index} className="group flex flex-col md:flex-row gap-8 p-6 bg-surface-container-low rounded-xl transition-all duration-300 hover:bg-surface-container-high">
                  <div className="w-full md:w-48 aspect-[3/4] overflow-hidden rounded-lg bg-surface-container-highest flex items-center justify-center">
                    {product.img
                      ? <img src={product.img} alt={product.name} className="w-full h-full object-cover" />
                      : <span className="material-symbols-outlined text-4xl text-on-surface-variant">inventory_2</span>
                    }
                  </div>
                  <div className="flex-1 flex flex-col justify-between py-2">
                    <div className="flex justify-between items-start">
                      <h3 className="text-2xl font-headline font-bold text-white mb-1">{product.name}</h3>
                      <button onClick={() => removeFromCart(product)} className="text-on-surface-variant hover:text-error transition-colors">
                        <span className="material-symbols-outlined">delete</span>
                      </button>
                    </div>
                    <div className="mt-8">
                      <span className="text-3xl font-headline font-extrabold text-white">${product.price.toFixed(2)}</span>
                    </div>
                  </div>
                </div>
              ))
            )}
          </div>

          <div className="lg:col-span-4 sticky top-32">
            <div className="bg-surface-container-high p-8 rounded-xl relative overflow-hidden">
              <div className="absolute -top-24 -right-24 w-48 h-48 bg-primary-container/10 blur-[100px] rounded-full"></div>
              <h2 className="text-xl font-headline font-bold text-white mb-8 border-b border-outline-variant/20 pb-4 tracking-tight">Resumen del Pedido</h2>
              <div className="space-y-4 mb-8 font-label">
                <div className="flex justify-between text-on-surface-variant">
                  <span>Subtotal</span><span className="text-white">${total.toFixed(2)}</span>
                </div>
                <div className="flex justify-between text-on-surface-variant">
                  <span>Envío Estándar</span><span className="text-white">${envio.toFixed(2)}</span>
                </div>
                <div className="flex justify-between text-on-surface-variant">
                  <span>Impuestos (IVA 19%)</span><span className="text-white">${iva.toFixed(2)}</span>
                </div>
              </div>
              <div className="pt-6 border-t border-outline-variant/30 mb-8">
                <div className="flex justify-between items-end">
                  <span className="text-xs uppercase tracking-widest text-on-surface-variant font-label">Total Final</span>
                  <span className="text-4xl font-headline font-extrabold text-white tracking-tighter">${(total + envio + iva).toFixed(2)}</span>
                </div>
              </div>
              <button className="w-full py-4 bg-primary-container hover:brightness-110 active:scale-[0.98] transition-all text-white font-headline font-bold uppercase tracking-widest text-sm rounded-lg shadow-2xl shadow-primary-container/20">
                Comprar
              </button>
              <p className="mt-6 text-center text-[10px] text-on-surface-variant uppercase tracking-widest font-label">Transacción segura protegida</p>
              <div className="mt-8 pt-8 border-t border-outline-variant/20">
                <label className="block text-xs uppercase tracking-widest text-on-surface-variant font-label mb-3">Código de Descuento</label>
                <div className="flex gap-2">
                  <input className="bg-surface-container-highest border-none rounded-lg text-sm w-full font-label tracking-wider placeholder:text-on-surface-variant/30 focus:ring-1 focus:ring-primary-container transition-all p-3" placeholder="INTRODUCE CÓDIGO" type="text" />
                  <button className="px-4 bg-surface-variant text-on-surface rounded-lg hover:bg-white/10 transition-colors">
                    <span className="material-symbols-outlined text-sm">arrow_forward</span>
                  </button>
                </div>
              </div>
            </div>
            <Link to="/catalogo" className="inline-flex items-center gap-2 mt-8 text-on-surface-variant hover:text-white transition-colors group font-label text-xs uppercase tracking-widest">
              <span className="material-symbols-outlined text-lg transition-transform group-hover:-translate-x-1">west</span>
              Continuar Comprando
            </Link>
          </div>
        </div>
      </main>
    </div>
  );
}

export default Carrito;
