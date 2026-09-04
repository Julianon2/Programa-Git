import React from 'react';

function Footer() {
  return (
    <footer className="w-full py-12 bg-[#12121d] border-t border-white/10">
      <div className="max-w-screen-2xl mx-auto px-8 flex flex-col md:flex-row justify-between items-center gap-6">
        <div className="text-lg font-bold text-white font-headline">Nemoralia</div>
        <div className="flex flex-wrap justify-center gap-8">
          <a className="font-label text-xs tracking-widest uppercase text-gray-500 hover:text-white transition-colors" href="#">Términos de Servicio</a>
          <a className="font-label text-xs tracking-widest uppercase text-gray-500 hover:text-white transition-colors" href="#">Política de Privacidad</a>
          <a className="font-label text-xs tracking-widest uppercase text-gray-500 hover:text-white transition-colors" href="#">Envíos</a>
          <a className="font-label text-xs tracking-widest uppercase text-gray-500 hover:text-white transition-colors" href="#">Contacto</a>
        </div>
        <div className="font-label text-xs tracking-widest uppercase text-gray-500">
          © 2024 Nemoralia. Midnight Editorial Collection.
        </div>
      </div>
    </footer>
  );
}

export default Footer;
