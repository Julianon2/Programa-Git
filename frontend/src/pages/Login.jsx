import React from 'react';
import { Link } from 'react-router-dom';

function Login() {
  return (
    <main className="flex items-center justify-center px-4 pt-24 pb-12 relative overflow-hidden min-h-screen">
      <div className="absolute top-1/4 -left-20 w-96 h-96 bg-primary-container/10 rounded-full blur-[120px]"></div>
      <div className="absolute bottom-1/4 -right-20 w-96 h-96 bg-tertiary-container/5 rounded-full blur-[120px]"></div>
      <div className="w-full max-w-md bg-surface-container-high rounded-xl p-10 relative z-10 shadow-2xl transition-all duration-500 hover:bg-surface-container-highest">
        <div className="mb-10 text-center">
          <h1 className="text-4xl font-extrabold tracking-tighter text-white mb-2 font-headline">Bienvenido</h1>
          <p className="text-on-surface-variant text-sm font-medium tracking-wide">Inicia sesión en la colección Midnight Editorial</p>
        </div>
        <form className="space-y-6">
          <div className="space-y-2">
            <label className="block text-xs font-bold uppercase tracking-widest text-on-surface-variant" htmlFor="email">Email</label>
            <div className="relative">
              <span className="material-symbols-outlined absolute left-4 top-1/2 -translate-y-1/2 text-on-surface-variant text-lg">mail</span>
              <input className="w-full bg-surface-container-lowest border-none rounded-lg py-4 pl-12 pr-4 text-white placeholder:text-on-surface-variant/40 focus:ring-0 transition-all border-b-2 border-transparent focus:border-primary-container" id="email" placeholder="nombre@ejemplo.com" type="email" />
            </div>
          </div>
          <div className="space-y-2">
            <label className="block text-xs font-bold uppercase tracking-widest text-on-surface-variant" htmlFor="password">Contraseña</label>
            <div className="relative">
              <span className="material-symbols-outlined absolute left-4 top-1/2 -translate-y-1/2 text-on-surface-variant text-lg">lock</span>
              <input className="w-full bg-surface-container-lowest border-none rounded-lg py-4 pl-12 pr-4 text-white placeholder:text-on-surface-variant/40 focus:ring-0 transition-all border-b-2 border-transparent focus:border-primary-container" id="password" placeholder="••••••••" type="password" />
            </div>
            <div className="text-right pt-1">
              <Link to="/olvidaste" className="text-xs text-on-surface-variant hover:text-white transition-colors duration-300">¿Olvidaste tu contraseña?</Link>
            </div>
          </div>
          <button className="w-full bg-gradient-to-r from-[#E40E20] to-[#8d1416] text-on-primary-container font-headline font-bold text-sm uppercase tracking-widest py-5 rounded-lg transition-all active:scale-95 hover:shadow-[0_0_20px_rgba(228,14,32,0.3)]" type="submit">
            Login
          </button>
        </form>
        <div className="mt-10 pt-8 border-t border-white/5 text-center">
          <p className="text-on-surface-variant text-sm mb-4">¿No tienes una cuenta?</p>
          <Link to="/registro" className="inline-flex items-center gap-2 text-white font-bold text-sm uppercase tracking-widest hover:text-primary-container transition-all group">
            Registro
            <span className="material-symbols-outlined text-sm transition-transform group-hover:translate-x-1">arrow_forward</span>
          </Link>
        </div>
      </div>
    </main>
  );
}

export default Login;
