package cl.thomas.mojitosecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.thomas.mojitosecommerce.entity.ItemCarrito;
import cl.thomas.mojitosecommerce.entity.Producto;
import cl.thomas.mojitosecommerce.service.ProductoService;
import jakarta.servlet.http.HttpSession;

@Controller
public class MojitoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping({"/", "/index"})
    public String verIndex(Model model, HttpSession session) {
        // 1. Cargar productos para la sección "Nuestros Mojitos" del index
        List<Producto> productos = productoService.listarTodos();
        model.addAttribute("listaProductos", productos);

        // 2. Calcular el contador para el badge del carrito en el navbar
        @SuppressWarnings("unchecked")
        List<ItemCarrito> carrito = (List<ItemCarrito>) session.getAttribute("carrito");
        int itemsCount = 0;
        if (carrito != null) {
            itemsCount = carrito.stream().mapToInt(ItemCarrito::getCantidad).sum();
        }
        model.addAttribute("itemsCount", itemsCount);

        return "index";
    }
}