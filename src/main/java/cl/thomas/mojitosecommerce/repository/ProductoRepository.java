package cl.thomas.mojitosecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.thomas.mojitosecommerce.entity.Producto;

/**
 * Interfaz que define el repositorio para la entidad {@link Producto}.
 * Proporciona los métodos estándar de CRUD gracias a la herencia de JpaRepository.
 * * @author Thomas Aravena
 * @version 1.0
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    // Aquí puedes agregar métodos personalizados en el futuro, por ejemplo:
    // List<Producto> findByPrecioLessThan(Double precio);
}