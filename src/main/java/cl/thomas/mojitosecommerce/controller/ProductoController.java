package cl.thomas.mojitosecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.thomas.mojitosecommerce.entity.Producto;
import cl.thomas.mojitosecommerce.entity.ItemCarrito;
import cl.thomas.mojitosecommerce.service.ProductoService;
import jakarta.servlet.http.HttpSession;

/**
 * Controlador para la visualización de la carta de productos.
 * * @author Thomas Aravena
 */
@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/productos")
    public String verPaginaDeProductos(Model model, HttpSession session) {
        // Cargar lista de tragos
        List<Producto> lista = productoService.listarTodos();
        model.addAttribute("listaProductos", lista);

        // Lógica mejorada para el contador del carrito
        @SuppressWarnings("unchecked")
        List<ItemCarrito> carrito = (List<ItemCarrito>) session.getAttribute("carrito");
        
        int itemsCount = 0;
        if (carrito != null) {
            // Sumamos las cantidades de cada item para un conteo real
            itemsCount = carrito.stream()
                                .mapToInt(ItemCarrito::getCantidad)
                                .sum();
        }
        
        model.addAttribute("itemsCount", itemsCount);

        return "productos";
    }
}