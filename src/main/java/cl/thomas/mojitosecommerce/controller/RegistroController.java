package cl.thomas.mojitosecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.thomas.mojitosecommerce.entity.Usuario;
import cl.thomas.mojitosecommerce.service.UsuarioService;

/**
 * Controlador encargado de gestionar el registro de nuevos usuarios en la plataforma.
 * Permite la creación de cuentas de acceso público para Empeda2 Drinks.
 *
 * @author Thomas Aravena
 * @version 1.1
 */
@Controller
public class RegistroController {

    private final UsuarioService usuarioService;

    public RegistroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Prepara y muestra el formulario de registro.
     *
     * @param model Modelo para pasar un objeto usuario vacío a la vista.
     * @return El nombre de la plantilla HTML "registro".
     */
    @GetMapping("/registro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    /**
     * Procesa la solicitud de creación de una nueva cuenta.
     * Si tiene éxito, redirige al login con un mensaje de confirmación.
     *
     * @param usuario Objeto vinculado al formulario con los datos del nuevo cliente.
     * @param model Modelo para gestionar mensajes de error en la misma vista.
     * @param redirect Atributos para enviar mensajes flash tras la redirección.
     * @return Redirección al login en éxito o retorno al formulario en caso de error.
     */
    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute Usuario usuario,
                                   Model model,
                                   RedirectAttributes redirect) {
        try {
            // Registro del usuario con rol USER por defecto
            usuarioService.registrarUsuarioPublico(usuario);
            
            // Mensaje de éxito personalizado para Empeda2 Drinks
            redirect.addFlashAttribute("mensajeExito", "¡Cuenta creada con éxito! Ya puedes iniciar sesión en Empeda2 Drinks.");
            
            return "redirect:/login";
            
        } catch (IllegalArgumentException e) {
            // Manejo de errores de validación (ej: contraseñas que no coinciden)
            model.addAttribute("error", e.getMessage());
            return "registro"; 
        } catch (Exception e) {
            // Manejo de errores generales (ej: correo electrónico duplicado)
            model.addAttribute("error", "Error al registrar: El correo electrónico ya se encuentra en uso.");
            return "registro";
        }
    }
}