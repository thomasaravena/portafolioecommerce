package cl.thomas.mojitosecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador encargado de gestionar el acceso al sistema Empeda2 Drinks.
 * * @author Thomas Aravena
 * @version 1.1
 */
@Controller
public class LoginController {

    /**
     * Muestra la vista del formulario de inicio de sesión.
     * Spring Security se encarga de procesar los datos enviados aquí.
     */
    @GetMapping("/login")
    public String login() {
        return "login"; 
    }
}