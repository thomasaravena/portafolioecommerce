package cl.thomas.mojitosecommerce.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.thomas.mojitosecommerce.entity.Producto;
import cl.thomas.mojitosecommerce.repository.ProductoRepository;
import jakarta.transaction.Transactional;

/**
 * Servicio encargado de la lógica de negocio para la gestión de productos.
 * Actúa como capa intermedia entre el controlador y el repositorio de productos
 * de Mojitos Ecommerce.
 *
 * @author Thomas Aravena
 * @version 1.0
 */
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    /**
     * Recupera la lista completa de productos disponibles en el catálogo.
     * @return Una lista de objetos {@link Producto}.
     */
    @Transactional
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    /**
     * Registra un nuevo producto o actualiza uno existente en la base de datos.
     * @param producto El objeto producto a persistir.
     */
    @Transactional
    public void guardar(Producto producto) {
        productoRepository.save(producto);
    }

    /**
     * Busca un producto específico mediante su identificador único.
     * Este método es utilizado por el flujo del carrito de compras.
     * @param id El ID del producto a buscar.
     * @return El objeto {@link Producto} si se encuentra, de lo contrario null.
     */
    @Transactional
    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    /**
     * Elimina un producto de la base de datos de forma permanente.
     * @param id El ID del producto a eliminar.
     */
    @Transactional
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}
