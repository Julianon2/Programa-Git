import React from 'react';
import { useCart } from '../context/CartContext';

const products = [
  { id: 1, name: 'Nemoralia Obsidian Vest', tag: 'Midnight Series 01', price: 420, img: 'https://images.unsplash.com/photo-1618932260643-eee4a2f652a6?w=600&q=80' },
  { id: 2, name: 'Ethereal Nocturne Coat', tag: 'Midnight Series 02', price: 1250, img: 'https://images.unsplash.com/photo-1539533018447-63fcce2678e3?w=600&q=80' },
  { id: 3, name: 'Void Leather Boots', tag: 'Accessories Series', price: 680, img: 'https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=600&q=80' },
  { id: 4, name: 'Textured Shadow Shirt', tag: 'Midnight Series 03', price: 290, img: 'https://images.unsplash.com/photo-1581655353564-df123a1eb820?w=600&q=80' },
  { id: 5, name: 'Abyssal Trousers', tag: 'Midnight Series 04', price: 350, img: 'https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=600&q=80' },
  { id: 6, name: 'Eclipse Silver Chain', tag: 'Art Editions', price: 510, img: 'https://images.unsplash.com/photo-1515562141207-7a88fb7ce338?w=600&q=80' },
];

function ProductCard({ product }) {
  const { addToCart } = useCart();
  return (
    <article className="group relative">
      <div className="aspect-[3/4] overflow-hidden rounded-xl bg-surface-container-low transition-all duration-700 group-hover:scale-[1.02] relative">
        <img alt={product.name} className="w-full h-full object-cover grayscale group-hover:grayscale-0 transition-all duration-700" src={product.img} />
        <div className="absolute inset-0 bg-gradient-to-t from-surface-container-lowest/80 to-transparent opacity-0 group-hover:opacity-100 transition-opacity duration-500"></div>
      </div>
      <div className="mt-6 flex flex-col gap-1">
        <div className="flex justify-between items-start">
          <h3 className="text-white font-headline text-lg font-bold tracking-tight">{product.name}</h3>
          <span className="text-white font-body font-medium">${product.price.toFixed(2)}</span>
        </div>
        <p className="text-on-surface-variant text-xs font-label uppercase tracking-widest mb-4">{product.tag}</p>
        <button
          onClick={() => addToCart(product)}
          className="w-full bg-primary-container text-on-primary-container py-4 rounded-lg font-headline text-xs font-bold uppercase tracking-widest opacity-0 group-hover:opacity-100 transition-all duration-300 translate-y-2 group-hover:translate-y-0 active:scale-95"
        >
          Agregar al carrito
        </button>
      </div>
    </article>
  );
}

function Catalogo() {
  return (
    <div className="bg-surface text-on-surface antialiased">
      <main className="pt-32 pb-24 max-w-screen-2xl mx-auto px-8">
        <header className="mb-16">
          <div className="flex flex-col md:flex-row md:items-end justify-between gap-6">
            <div>
              <span className="text-primary-container font-headline text-xs tracking-[0.3em] uppercase font-bold mb-2 block">Midnight Editorial Collection</span>
              <h1 className="text-5xl md:text-7xl font-headline font-extrabold tracking-tighter text-white">Catálogo</h1>
            </div>
            <div className="flex items-center gap-4 text-on-surface-variant text-sm font-label uppercase tracking-widest">
              <span>124 Objetos Curados</span>
              <span className="h-px w-12 bg-white/20"></span>
              <span>Edición Limitada</span>
            </div>
          </div>
        </header>
        <div className="flex flex-col md:flex-row gap-12">
          <aside className="w-full md:w-64 flex-shrink-0">
            <div className="sticky top-32 space-y-12">
              <section>
                <h3 className="text-white font-headline text-sm uppercase tracking-widest font-bold mb-6">Categoría</h3>
                <div className="space-y-4">
                  {['Best Sellers', 'Midnight Series', 'Accesorios', 'Ediciones de Arte'].map((cat) => (
                    <label key={cat} className="flex items-center group cursor-pointer">
                      <input className="hidden peer" type="checkbox" />
                      <div className="w-4 h-4 rounded-full border border-outline-variant peer-checked:bg-primary-container peer-checked:border-primary-container transition-all"></div>
                      <span className="ml-3 text-sm text-gray-400 group-hover:text-white transition-colors">{cat}</span>
                    </label>
                  ))}
                </div>
              </section>
              <section>
                <h3 className="text-white font-headline text-sm uppercase tracking-widest font-bold mb-6">Precio</h3>
                <div className="px-2">
                  <input className="w-full h-1 bg-surface-container-high rounded-full appearance-none cursor-pointer accent-primary-container" type="range" />
                  <div className="flex justify-between mt-4 text-[10px] text-gray-500 uppercase tracking-tighter">
                    <span>$0 USD</span><span>$5000 USD</span>
                  </div>
                </div>
              </section>
              <section>
                <h3 className="text-white font-headline text-sm uppercase tracking-widest font-bold mb-6">Talla</h3>
                <div className="grid grid-cols-3 gap-2">
                  {['S', 'M', 'L', 'XL', 'XXL'].map((t) => (
                    <button key={t} className="py-2 text-[10px] font-bold border border-white/10 text-gray-400 hover:border-primary-container hover:text-white transition-all rounded-lg uppercase">{t}</button>
                  ))}
                </div>
              </section>
              <button className="w-full py-3 text-xs font-headline uppercase font-bold tracking-[0.2em] border border-white/10 hover:bg-white hover:text-surface transition-all rounded-lg active:scale-95">Limpiar Filtros</button>
            </div>
          </aside>
          <div className="flex-grow">
            <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-x-8 gap-y-16">
              {products.map((p) => (
                <ProductCard key={p.id} product={p} />
              ))}
            </div>
          </div>
        </div>
      </main>
    </div>
  );
}

export default Catalogo;
