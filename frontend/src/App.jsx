import React from 'react';
import { Routes, Route } from 'react-router-dom';
import './index.css';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import Home from './pages/Home';
import Login from './pages/Login';
import Registro from './pages/Registro';
import Olvidaste from './pages/Olvidaste';
import Carrito from './pages/Carrito';
import Catalogo from './pages/Catalogo';

function App() {
  return (
    <div className="dark min-h-screen bg-surface flex flex-col">
      <Navbar />
      <div className="flex-grow">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/home" element={<Home />} />
          <Route path="/catalogo" element={<Catalogo />} />
          <Route path="/login" element={<Login />} />
          <Route path="/registro" element={<Registro />} />
          <Route path="/olvidaste" element={<Olvidaste />} />
          <Route path="/shopping_cart" element={<Carrito />} />
        </Routes>
      </div>
      <Footer />
    </div>
  );
}

export default App;
