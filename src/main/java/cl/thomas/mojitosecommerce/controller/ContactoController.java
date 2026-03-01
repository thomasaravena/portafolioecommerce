package cl.thomas.mojitosecommerce.controller;

import cl.thomas.mojitosecommerce.entity.Consulta;
import cl.thomas.mojitosecommerce.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactoController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping("/contacto/enviar")
    public String enviarConsulta(@ModelAttribute Consulta consulta, RedirectAttributes flash) {
        try {
            consultaService.guardar(consulta);
            flash.addFlashAttribute("success", "¡Mensaje enviado! Te contactaremos pronto.");
        } catch (Exception e) {
            flash.addFlashAttribute("error", "Hubo un problema al enviar tu mensaje.");
        }
        return "redirect:/#contacto"; // Redirige a la sección de contacto en el inicio
    }
}