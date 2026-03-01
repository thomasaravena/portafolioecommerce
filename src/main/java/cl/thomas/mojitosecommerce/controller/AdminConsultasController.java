package cl.thomas.mojitosecommerce.controller;

import cl.thomas.mojitosecommerce.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/consultas")
public class AdminConsultasController {

    @Autowired
    private ConsultaService consultaService;

    // Listado de consultas
    @GetMapping
    public String listarConsultas(Model model) {
        model.addAttribute("consultas", consultaService.listarTodas());
        return "admin/consultas-lista";
    }

    // Eliminar consulta
    @GetMapping("/eliminar/{id}")
    public String eliminarConsulta(@PathVariable Long id, RedirectAttributes flash) {
        consultaService.eliminar(id);
        flash.addFlashAttribute("success", "Consulta eliminada correctamente");
        return "redirect:/admin/consultas";
    }
}