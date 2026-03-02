-- ==========================================================
-- SCRIPT DE CREACIÓN DE BASE DE DATOS Y ESTRUCTURA
-- Proyecto: Empeda2 Drinks (Mojitos Ecommerce)
-- Autor: Thomas Aravena
-- ==========================================================

-- 1. CREACIÓN DE LA BASE DE DATOS (Ejecutar por separado si es necesario)
-- DROP DATABASE IF EXISTS mojitosdb;
-- CREATE DATABASE mojitosdb;

-- 2. CARGA DE PRODUCTOS DE PRUEBA
INSERT INTO productos (nombre, descripcion, precio, stock, imagen_url) 
VALUES 
('Mojito Venom', 'con y sin alcohol', 12000.00, 10, 'https://image2url.com/r2/default/images/1772310801263-056da40f-a347-41cd-be0f-426c7dc8ccd0.jpeg'),
('Colado blue', 'con y sin alcohol', 12000.00, 20, 'https://image2url.com/r2/default/images/1772310695290-fcdf2de6-be36-448b-a7cd-7a698d256999.jpeg'),
('Mojito Choco Manjar', 'Explosión de sabor dulce, con y sin alcohol', 13500.00, 15, 'https://image2url.com/r2/default/images/1772310768738-b384cb7c-a99c-4f42-862d-2c146ab70c6f.jpeg'),
('Mojito Arándano', 'Frutos del bosque seleccionados, con y sin alcohol', 12500.00, 12, 'https://image2url.com/r2/default/images/1772310791091-035f3563-6ffb-49d6-a296-334baf868b45.jpeg'),
('Mojito Naranja', 'Cítrico refrescante, con y sin alcohol', 11000.00, 18, 'https://image2url.com/r2/default/images/1772310613709-1fa3fe23-4211-4b4b-9209-8d4c9a4dbc34.jpeg'),
('Mojito Blue', 'Clásico blue curacao, con y sin alcohol', 12000.00, 25, 'https://image2url.com/r2/default/images/1772310780886-39cde0ff-1ee1-4ee7-82fa-6d14e9f66f90.jpeg');