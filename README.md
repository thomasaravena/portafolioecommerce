# 🍸 Mojitos E-commerce - Portafolio Final

Este proyecto representa la culminación del Módulo 7, integrando una solución de comercio electrónico completa para la venta de mojitos. La aplicación cuenta con una estética **Neon-Cyberpunk**, un catálogo dinámico, sistema de carrito de compras funcional y un panel administrativo robusto.

---

## 🎯 Propósito del Proyecto
Entregar una versión final operativa (MVP) que demuestre la integración de tecnologías Spring Boot, persistencia de datos con PostgreSQL y seguridad perimetral con Spring Security, orientada a ser una pieza clave de portafolio profesional.

---

## 📺 Demostración en Video (Ejecución)
Haz clic en la imagen a continuación para ver el video con la funcionalidad completa de la plataforma:

[![Ver Demo en YouTube](https://img.youtube.com/vi/1BfcFiXnE00/0.jpg)](https://youtu.be/1BfcFiXnE00)

---

## 🚀 Guía de Ejecución Local

### Requisitos Previos
* **Java:** JDK 21 instalado.
* **Maven:** Versión 3.8 o superior.
* **Base de Datos:** PostgreSQL 16+ activo.
* **IDE:** Eclipse (STS) o VS Code.

### Pasos para Iniciar

1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/thomasaravena/portafolioecommerce.git](https://github.com/thomasaravena/portafolioecommerce.git)

    Configuración de Base de Datos:

        Acceder a PostgreSQL y ejecutar:
    SQL

    CREATE DATABASE mojitosdb;

    Ajustar Credenciales:

        En el archivo src/main/resources/application.properties, actualizar los campos de username y password con tus credenciales locales de Postgres.

    Lanzar Aplicación:

        Desde el IDE: Clic derecho en el proyecto -> Run As -> Spring Boot App.

        Desde Terminal: ```bash
        mvn spring-boot:run


    Acceso: * Abrir el navegador en: http://localhost:8080

🔑 Credenciales de Prueba (MVP)

Para facilitar la evaluación de roles y permisos, el sistema inicializa los siguientes usuarios automáticamente:
Rol	Usuario (Email)	Contraseña
ADMINISTRADOR	sebastian@bootcamp.cl	admin123
CLIENTE	debes iniciar sesión, con correo y contraseña en LOGIN.
🛠️ Alcance Técnico (Rúbrica)
1. Autenticación y Roles

    Cliente: Acceso a catálogo, gestión de carrito (agregar, quitar, actualizar unidades) y visualización de totales correctos.

    Administrador: Acceso exclusivo a /admin para el CRUD completo de productos (Listar, Crear, Editar, Eliminar) y gestión de consultas.

2. Persistencia y Estabilidad

    BD Real: Almacenamiento persistente de usuarios, roles y productos en PostgreSQL.

    Validaciones: Formularios protegidos con validaciones de campos obligatorios y tipos de datos (HTML5 + Thymeleaf).

    UI Consistente: Diseño basado en Bootstrap con estilos personalizados para una experiencia de usuario inmersiva.

3. Rutas Principales

    Públicas: /, /login, /registro, /contacto

    Privadas (User): /carrito

    Privadas (Admin): /admin/productos, /admin/consultas

Repositorio oficial: https://github.com/thomasaravena/portafolioecommerce

Desarrollado por Thomas Aravena.
