package cl.thomas.mojitosecommerce.service;

import cl.thomas.mojitosecommerce.entity.Consulta;
import cl.thomas.mojitosecommerce.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> listarTodas() {
        return consultaRepository.findAll();
    }

    public void guardar(Consulta consulta) {
        consultaRepository.save(consulta);
    }

    public void eliminar(Long id) {
        consultaRepository.deleteById(id);
    }
}