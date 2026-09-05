-- Script de creacion de base de datos para el modulo de Productos - Proyecto Nemoralia
-- GA7-220501096-AA2-EV01

CREATE DATABASE IF NOT EXISTS nemoralia_db;
USE nemoralia_db;

CREATE TABLE IF NOT EXISTS producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL DEFAULT 0
);

-- Datos de prueba
INSERT INTO producto (nombre, descripcion, precio, stock) VALUES
('Camiseta Nemoralia', 'Camiseta de algodon edicion Midnight Editorial', 59900.00, 25),
('Chaqueta Villavicencio', 'Chaqueta impermeable linea urbana', 189900.00, 10),
('Gorra Nemoralia', 'Gorra bordada logo Nemoralia', 39900.00, 40);
