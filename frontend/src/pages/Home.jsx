import React from 'react';
import { Link } from 'react-router-dom';

const featured = [
  {
    id: 1, name: 'Cronos Obsidian', tag: 'Limited Edition',
    desc: 'Reloj de precisión con acabado en titanio negro mate y cristal de zafiro ahumado.',
    price: '$450.00', large: true,
    img: 'https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=800&q=80',
  },
  {
    id: 2, name: 'Sonic Noir', tag: null, desc: 'Aislamiento acústico absoluto.',
    price: '$320.00', large: false,
    img: 'https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=600&q=80',
  },
  {
    id: 3, name: 'Portfolio Nero', tag: null, desc: 'Cuero artesanal de grano completo.',
    price: '$210.00', large: false,
    img: 'https://images.unsplash.com/photo-1548036328-c9fa89d128fa?w=600&q=80',
  },
];

function Home() {
  return (
    <div className="bg-surface text-on-surface overflow-x-hidden">
      {/* Hero */}
      <section className="relative min-h-screen flex items-center justify-center pt-24 overflow-hidden">
        <div className="absolute inset-0" style={{ background: 'radial-gradient(circle at center, rgba(228,14,32,0.05) 0%, rgba(18,18,29,0) 70%)' }}></div>
        <div className="absolute top-1/4 -right-20 w-96 h-96 bg-primary-container/10 blur-[120px] rounded-full"></div>
        <div className="absolute bottom-1/4 -left-20 w-80 h-80 bg-tertiary/5 blur-[100px] rounded-full"></div>
        <div className="max-w-screen-2xl mx-auto px-8 w-full grid grid-cols-1 md:grid-cols-12 gap-12 items-center relative z-10">
          <div className="md:col-span-7">
            <span className="inline-block px-4 py-1.5 rounded-full bg-surface-container-high border border-outline-variant/20 text-xs font-label uppercase tracking-[0.2em] text-primary-container mb-8">
              Midnight Editorial Collection
            </span>
            <h1 className="text-6xl md:text-8xl font-headline font-extrabold tracking-tighter leading-[0.9] text-white mb-6">Nemoralia</h1>
            <p className="text-xl md:text-2xl font-body text-on-surface-variant font-light tracking-wide mb-10 max-w-xl">
              Elegancia en la Oscuridad. Curamos piezas de diseño que cobran vida cuando el sol se pone.
            </p>
            <div className="flex flex-wrap gap-6">
              <Link to="/catalogo" className="px-10 py-5 bg-primary-container text-on-primary-container rounded-lg font-headline font-bold uppercase tracking-widest text-sm transition-all duration-300 hover:scale-[1.02] hover:shadow-[0_0_40px_rgba(228,14,32,0.3)] active:scale-95">
                Ver Catálogo
              </Link>
              <button className="px-10 py-5 bg-transparent border border-outline-variant/30 text-white rounded-lg font-headline font-bold uppercase tracking-widest text-sm transition-all duration-300 hover:bg-white/5 active:scale-95">
                Explorar Lookbook
              </button>
            </div>
          </div>
          <div className="md:col-span-5 relative">
            <div className="aspect-[3/4] rounded-xl overflow-hidden bg-surface-container-low shadow-2xl relative">
              <img className="w-full h-full object-cover grayscale brightness-75 hover:grayscale-0 transition-all duration-700" src="https://images.unsplash.com/photo-1509631179647-0177331693ae?w=800&q=80" alt="Editorial" />
              <div className="absolute inset-0 bg-gradient-to-t from-surface via-transparent to-transparent opacity-60"></div>
            </div>
            <div className="absolute -bottom-6 -left-6 bg-surface-container-high p-6 rounded-lg shadow-2xl backdrop-blur-md border border-outline-variant/10 max-w-[200px]">
              <p className="text-[10px] font-label uppercase tracking-widest text-primary-container mb-2">New Arrival</p>
              <p className="text-sm font-headline font-bold text-white leading-tight">Sombra Nocturna Collection Vol. 1</p>
            </div>
          </div>
        </div>
      </section>

      {/* Featured Products */}
      <section className="bg-surface-container-low py-32">
        <div className="max-w-screen-2xl mx-auto px-8">
          <div className="flex justify-between items-end mb-20">
            <div>
              <h2 className="text-4xl md:text-5xl font-headline font-bold tracking-tighter text-white mb-4">Piezas Destacadas</h2>
              <p className="text-on-surface-variant font-body max-w-md">Una selección de artículos diseñados para elevar la estética del espacio contemporáneo.</p>
            </div>
            <Link to="/catalogo" className="group flex items-center gap-2 text-primary-container font-headline font-bold uppercase text-xs tracking-widest">
              Ver Todo el Catálogo
              <span className="material-symbols-outlined text-sm group-hover:translate-x-1 transition-transform">arrow_forward</span>
            </Link>
          </div>
          <div className="grid grid-cols-1 md:grid-cols-12 gap-8">
            <div className="md:col-span-8 group">
              <div className="bg-surface-container-high rounded-xl overflow-hidden flex flex-col md:flex-row h-full transition-all duration-500 hover:scale-[1.01]">
                <div className="md:w-3/5 h-80 md:h-auto relative overflow-hidden">
                  <img className="w-full h-full object-cover transition-transform duration-700 group-hover:scale-110" src={featured[0].img} alt={featured[0].name} />
                </div>
                <div className="md:w-2/5 p-10 flex flex-col justify-center">
                  <p className="text-xs font-label uppercase tracking-widest text-primary-container mb-4">{featured[0].tag}</p>
                  <h3 className="text-3xl font-headline font-bold text-white mb-4">{featured[0].name}</h3>
                  <p className="text-on-surface-variant font-body mb-8 text-sm leading-relaxed">{featured[0].desc}</p>
                  <div className="mt-auto flex items-center justify-between">
                    <span className="text-2xl font-headline font-light text-white">{featured[0].price}</span>
                    <button className="bg-white/5 hover:bg-primary-container hover:text-white p-3 rounded-full transition-all active:scale-90 border border-outline-variant/20">
                      <span className="material-symbols-outlined">shopping_bag</span>
                    </button>
                  </div>
                </div>
              </div>
            </div>
            {featured.slice(1).map((p) => (
              <div key={p.id} className="md:col-span-4 group">
                <div className="bg-surface-container-high rounded-xl overflow-hidden h-full flex flex-col transition-all duration-500 hover:scale-[1.01]">
                  <div className="h-80 relative overflow-hidden">
                    <img className="w-full h-full object-cover transition-transform duration-700 group-hover:scale-110" src={p.img} alt={p.name} />
                  </div>
                  <div className="p-8 flex flex-col grow">
                    <h3 className="text-xl font-headline font-bold text-white mb-2">{p.name}</h3>
                    <p className="text-sm text-on-surface-variant font-body mb-6">{p.desc}</p>
                    <div className="mt-auto flex items-center justify-between">
                      <span className="text-lg font-headline font-light text-white">{p.price}</span>
                      <button className="text-primary-container hover:text-white transition-colors">
                        <span className="material-symbols-outlined">add_circle</span>
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* Editorial */}
      <section className="py-32 bg-surface">
        <div className="max-w-screen-2xl mx-auto px-8 grid grid-cols-1 md:grid-cols-2 gap-24 items-center">
          <div className="relative">
            <div className="aspect-square bg-surface-container rounded-lg overflow-hidden border border-outline-variant/10">
              <img className="w-full h-full object-cover opacity-60" src="https://images.unsplash.com/photo-1441984904996-e0b6ba687e04?w=800&q=80" alt="Boutique" />
            </div>
            <div className="absolute -top-12 -right-12 w-48 h-48 border-t border-r border-primary-container/30"></div>
            <div className="absolute -bottom-12 -left-12 w-48 h-48 border-b border-l border-primary-container/30"></div>
          </div>
          <div>
            <h3 className="text-5xl font-headline font-bold text-white mb-8 leading-[1.1]">La Filosofía del Oscurantismo.</h3>
            <p className="text-on-surface-variant text-lg font-body mb-8 leading-relaxed">
              No buscamos la luz, sino la forma en que los objetos interactúan con la sombra. Nemoralia nace de la necesidad de crear un refugio estético para aquellos que encuentran belleza en la penumbra.
            </p>
            <div className="space-y-6">
              {[
                { icon: 'verified', title: 'Calidad Artesanal', desc: 'Cada pieza es seleccionada por su durabilidad y carácter único.' },
                { icon: 'auto_awesome', title: 'Diseño Atemporal', desc: 'Estética que trasciende las tendencias efímeras del mercado.' },
              ].map((item) => (
                <div key={item.title} className="flex gap-4">
                  <span className="material-symbols-outlined text-primary-container">{item.icon}</span>
                  <div>
                    <h4 className="font-headline font-bold text-white uppercase text-xs tracking-widest mb-1">{item.title}</h4>
                    <p className="text-sm text-on-surface-variant font-body">{item.desc}</p>
                  </div>
                </div>
              ))}
            </div>
          </div>
        </div>
      </section>

      {/* Newsletter */}
      <section className="py-24 bg-surface-container-highest/30 backdrop-blur-sm">
        <div className="max-w-screen-xl mx-auto px-8 text-center">
          <h2 className="text-3xl md:text-5xl font-headline font-bold text-white mb-6">Únete al Círculo Nocturno</h2>
          <p className="text-on-surface-variant font-body text-lg mb-12 max-w-2xl mx-auto">Suscríbete para recibir lanzamientos exclusivos y acceso anticipado a nuestras colecciones cápsula.</p>
          <form className="max-w-md mx-auto flex gap-2">
            <input className="grow bg-surface-container-high border-none rounded-lg px-6 py-4 text-white focus:ring-2 focus:ring-primary-container font-label text-sm transition-all" placeholder="Email Address" type="email" />
            <button className="bg-primary-container text-on-primary-container px-8 py-4 rounded-lg font-headline font-bold uppercase tracking-widest text-xs transition-all hover:bg-secondary-container">Unirse</button>
          </form>
        </div>
      </section>
    </div>
  );
}

export default Home;
