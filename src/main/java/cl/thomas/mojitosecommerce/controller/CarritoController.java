package cl.thomas.mojitosecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.thomas.mojitosecommerce.entity.ItemCarrito;
import cl.thomas.mojitosecommerce.entity.Producto;
import cl.thomas.mojitosecommerce.service.ProductoService;
import jakarta.servlet.http.HttpSession;

/**
 * Controlador centralizado para el flujo de compra de Empeda2 Drinks.
 * Maneja el carrito y la finalización del pedido.
 * @author Thomas Aravena
 */
@Controller
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/agregar/{id}")
    public String agregarAlCarrito(@PathVariable Long id, HttpSession session) {
        @SuppressWarnings("unchecked")
        List<ItemCarrito> carrito = (List<ItemCarrito>) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new ArrayList<>();
        }

        Producto productoDeseado = productoService.obtenerPorId(id);

        if (productoDeseado != null) {
            boolean existe = false;
            for (ItemCarrito item : carrito) {
                if (item.getProducto().getId().equals(id)) {
                    item.setCantidad(item.getCantidad() + 1);
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                carrito.add(new ItemCarrito(productoDeseado, 1));
            }
        }

        session.setAttribute("carrito", carrito);
        session.setAttribute("itemsCount", calcularTotalItems(carrito));
        
        return "redirect:/carrito/ver";
    }

    @GetMapping("/ver")
    public String verCarrito(Model model, HttpSession session) {
        @SuppressWarnings("unchecked")
        List<ItemCarrito> carrito = (List<ItemCarrito>) session.getAttribute("carrito");
        
        if (carrito == null) carrito = new ArrayList<>();
        
        double total = carrito.stream().mapToDouble(ItemCarrito::getSubtotal).sum();

        model.addAttribute("itemsCount", calcularTotalItems(carrito));
        model.addAttribute("carrito", carrito);
        model.addAttribute("totalCarrito", total);

        return "carrito-vista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDelCarrito(@PathVariable Long id, HttpSession session) {
        @SuppressWarnings("unchecked")
        List<ItemCarrito> carrito = (List<ItemCarrito>) session.getAttribute("carrito");
        
        if (carrito != null) {
            carrito.removeIf(item -> item.getProducto().getId().equals(id));
            session.setAttribute("carrito", carrito);
            session.setAttribute("itemsCount", calcularTotalItems(carrito));
        }
        return "redirect:/carrito/ver";
    }

    @GetMapping("/vaciar")
    public String vaciarCarrito(HttpSession session) {
        session.removeAttribute("carrito");
        session.setAttribute("itemsCount", 0);
        return "redirect:/carrito/ver";
    }

    @GetMapping("/finalizar")
    public String finalizarCompra(HttpSession session, Model model) {
        @SuppressWarnings("unchecked")
        List<ItemCarrito> carrito = (List<ItemCarrito>) session.getAttribute("carrito");

        if (carrito == null || carrito.isEmpty()) {
            return "redirect:/productos";
        }

        double total = carrito.stream().mapToDouble(ItemCarrito::getSubtotal).sum();
        String numOrden = "MOJ-" + System.currentTimeMillis() / 1000;

        model.addAttribute("nroOrden", numOrden);
        model.addAttribute("total", total);

        // Limpieza total
        session.removeAttribute("carrito");
        session.setAttribute("itemsCount", 0);

        return "compra-exitosa";
    }

    private int calcularTotalItems(List<ItemCarrito> carrito) {
        if (carrito == null) return 0;
        return carrito.stream().mapToInt(ItemCarrito::getCantidad).sum();
    }
}