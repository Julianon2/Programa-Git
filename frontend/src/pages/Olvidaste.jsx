import React, { useState } from 'react';
import { Link } from 'react-router-dom';

function Olvidaste() {
  const [mensaje, setMensaje] = useState('');
  const enviar = (e) => {
    e.preventDefault();
    setMensaje('La recuperación de contraseña por correo estará disponible en la próxima versión. Escríbenos a hola@nemoralia.com para restablecer tu acceso.');
  };

  return (
    <main className="flex items-center justify-center px-4 pt-24 pb-12 relative overflow-hidden min-h-screen">
      <div className="absolute top-1/4 -left-20 w-96 h-96 bg-primary-container/10 rounded-full blur-[120px]"></div>
      <div className="absolute bottom-1/4 -right-20 w-96 h-96 bg-tertiary-container/5 rounded-full blur-[120px]"></div>
      <div className="w-full max-w-md bg-surface-container-high rounded-xl p-10 relative z-10 shadow-2xl">
        <div className="mb-10 text-center">
          <h1 className="text-4xl font-extrabold tracking-tighter text-white mb-2 font-headline">Recupera tu acceso</h1>
          <p className="text-on-surface-variant text-sm font-medium tracking-wide">Te enviaremos un enlace a tu correo electrónico</p>
        </div>
        <form className="space-y-6" onSubmit={enviar}>
          <div className="space-y-2">
            <label className="block text-xs font-bold uppercase tracking-widest text-on-surface-variant" htmlFor="email">Correo Electrónico</label>
            <div className="relative">
              <span className="material-symbols-outlined absolute left-4 top-1/2 -translate-y-1/2 text-on-surface-variant text-lg">mail</span>
              <input className="w-full bg-surface-container-lowest border-none rounded-lg py-4 pl-12 pr-4 text-white placeholder:text-on-surface-variant/40 focus:ring-0 transition-all border-b-2 border-transparent focus:border-primary-container" id="email" placeholder="nombre@ejemplo.com" type="email" required />
            </div>
          </div>
          <button className="w-full bg-gradient-to-r from-[#E40E20] to-[#8d1416] text-on-primary-container font-headline font-bold text-sm uppercase tracking-widest py-5 rounded-lg transition-all active:scale-95 hover:shadow-[0_0_20px_rgba(228,14,32,0.3)]" type="submit">
            Enviar enlace
          </button>
          {mensaje && <p role="status" className="text-sm text-center text-on-surface-variant">{mensaje}</p>}
        </form>
        <div className="mt-10 pt-8 border-t border-white/5 text-center">
          <Link to="/login" className="inline-flex items-center gap-2 text-on-surface-variant hover:text-white transition-colors group font-label text-xs uppercase tracking-widest">
            <span className="material-symbols-outlined text-lg transition-transform group-hover:-translate-x-1">west</span>
            Regresar al inicio de sesión
          </Link>
        </div>
      </div>
    </main>
  );
}

export default Olvidaste;
