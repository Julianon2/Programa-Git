import React from 'react';
import { Link } from 'react-router-dom';

function Registro() {
  return (
    <main className="flex items-center justify-center pt-24 pb-12 px-6 relative overflow-hidden min-h-screen">
      <div className="absolute top-1/4 -left-20 w-96 h-96 bg-primary-container/10 blur-[120px] rounded-full pointer-events-none"></div>
      <div className="absolute bottom-1/4 -right-20 w-96 h-96 bg-secondary-container/5 blur-[120px] rounded-full pointer-events-none"></div>
      <div className="w-full max-w-2xl z-10">
        <div className="mb-12 text-center md:text-left">
          <span className="font-label text-primary-container text-xs tracking-[0.3em] uppercase font-bold mb-4 block">Bienvenida a la Colección</span>
          <h1 className="font-headline text-5xl md:text-6xl font-extrabold tracking-tighter text-white leading-tight">Únete a Nemoralia.</h1>
          <p className="font-body text-on-surface-variant mt-4 max-w-md text-lg">Acceso exclusivo a nuestra curaduría Midnight Editorial y lanzamientos limitados.</p>
        </div>
        <div className="bg-surface-container-low rounded-xl p-8 md:p-12 shadow-2xl border border-white/5">
          <form className="space-y-8">
            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
              <div className="space-y-2">
                <label className="font-label text-[10px] uppercase tracking-widest text-on-surface-variant font-bold px-1">Nombre</label>
                <input className="w-full bg-surface-container-high border-none rounded-lg p-4 text-on-surface focus:ring-2 focus:ring-primary-container transition-all placeholder:text-surface-variant" placeholder="Ej. Julian" type="text" />
              </div>
              <div className="space-y-2">
                <label className="font-label text-[10px] uppercase tracking-widest text-on-surface-variant font-bold px-1">Apellido</label>
                <input className="w-full bg-surface-container-high border-none rounded-lg p-4 text-on-surface focus:ring-2 focus:ring-primary-container transition-all placeholder:text-surface-variant" placeholder="Ej. Sorel" type="text" />
              </div>
            </div>
            <div className="space-y-2">
              <label className="font-label text-[10px] uppercase tracking-widest text-on-surface-variant font-bold px-1">Email</label>
              <input className="w-full bg-surface-container-high border-none rounded-lg p-4 text-on-surface focus:ring-2 focus:ring-primary-container transition-all placeholder:text-surface-variant" placeholder="hola@nemoralia.com" type="email" />
            </div>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
              <div className="space-y-2">
                <label className="font-label text-[10px] uppercase tracking-widest text-on-surface-variant font-bold px-1">Contraseña</label>
                <input className="w-full bg-surface-container-high border-none rounded-lg p-4 text-on-surface focus:ring-2 focus:ring-primary-container transition-all" placeholder="••••••••" type="password" />
              </div>
              <div className="space-y-2">
                <label className="font-label text-[10px] uppercase tracking-widest text-on-surface-variant font-bold px-1">Confirmar contraseña</label>
                <input className="w-full bg-surface-container-high border-none rounded-lg p-4 text-on-surface focus:ring-2 focus:ring-primary-container transition-all" placeholder="••••••••" type="password" />
              </div>
            </div>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
              <div className="space-y-2">
                <label className="font-label text-[10px] uppercase tracking-widest text-on-surface-variant font-bold px-1">Fecha de nacimiento</label>
                <input className="w-full bg-surface-container-high border-none rounded-lg p-4 text-on-surface focus:ring-2 focus:ring-primary-container transition-all" type="date" />
              </div>
              <div className="space-y-2">
                <label className="font-label text-[10px] uppercase tracking-widest text-on-surface-variant font-bold px-1">Teléfono</label>
                <input className="w-full bg-surface-container-high border-none rounded-lg p-4 text-on-surface focus:ring-2 focus:ring-primary-container transition-all placeholder:text-surface-variant" placeholder="+57 000 000 0000" type="tel" />
              </div>
            </div>
            <div className="space-y-2">
              <label className="font-label text-[10px] uppercase tracking-widest text-on-surface-variant font-bold px-1">Dirección</label>
              <input className="w-full bg-surface-container-high border-none rounded-lg p-4 text-on-surface focus:ring-2 focus:ring-primary-container transition-all placeholder:text-surface-variant" placeholder="Calle, Ciudad, País" type="text" />
            </div>
            <div className="pt-6 space-y-6">
              <div className="flex items-start gap-3">
                <input className="mt-1 rounded bg-surface-container-highest border-none text-primary-container" type="checkbox" />
                <label className="text-xs text-on-surface-variant font-body leading-relaxed">
                  Acepto los <a className="text-white underline underline-offset-4 decoration-primary-container/50 hover:decoration-primary-container transition-all" href="#">Términos de Servicio</a> y la <a className="text-white underline underline-offset-4 decoration-primary-container/50 hover:decoration-primary-container transition-all" href="#">Política de Privacidad</a>.
                </label>
              </div>
              <button className="w-full bg-primary-container hover:bg-primary-container/90 text-on-primary-container font-headline font-bold py-5 rounded-lg text-sm tracking-widest uppercase transition-all active:scale-[0.98] shadow-lg shadow-primary-container/20" type="submit">
                Registrarse
              </button>
              <p className="text-center text-xs font-label text-on-surface-variant tracking-wider uppercase">
                ¿Ya tienes cuenta? <Link to="/login" className="text-white font-bold hover:text-primary-container transition-colors">Inicia Sesión</Link>
              </p>
            </div>
          </form>
        </div>
      </div>
    </main>
  );
}

export default Registro;
