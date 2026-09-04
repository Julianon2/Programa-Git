import React from 'react';
import { Link, useLocation } from 'react-router-dom';

function Navbar() {
  const { pathname } = useLocation();

  const linkClass = (path) =>
    `font-headline tracking-tight text-sm uppercase font-semibold transition-colors duration-300 relative ${
      pathname === path
        ? "text-white after:content-[''] after:absolute after:-bottom-2 after:left-1/2 after:-translate-x-1/2 after:w-1.5 after:h-1.5 after:bg-primary-container after:rounded-full"
        : 'text-gray-400 hover:text-white'
    }`;

  return (
    <nav className="fixed top-0 w-full z-50 bg-[#12121d]/80 backdrop-blur-lg bg-gradient-to-b from-[#1b1a26] to-transparent">
      <div className="max-w-screen-2xl mx-auto px-8 flex justify-between items-center h-24">
        <Link to="/home" className="text-2xl font-bold tracking-tighter text-white font-headline">
          Nemoralia
        </Link>
        <div className="hidden md:flex items-center space-x-12">
          <Link to="/home" className={linkClass('/home')}>Home</Link>
          <Link to="/catalogo" className={linkClass('/catalogo')}>Catálogo</Link>
          <Link to="/shopping_cart" className={linkClass('/shopping_cart')}>Carrito</Link>
        </div>
        <div className="flex items-center gap-6">
          <Link to="/login" className={linkClass('/login')}>Login</Link>
          <Link
            to="/registro"
            className="bg-primary-container text-on-primary-container px-6 py-2.5 rounded-lg font-headline text-sm uppercase font-semibold transition-all duration-300 hover:bg-secondary-container active:scale-95"
          >
            Registro
          </Link>
        </div>
      </div>
      <div className="h-px w-full bg-gradient-to-r from-transparent via-white/5 to-transparent"></div>
    </nav>
  );
}

export default Navbar;
