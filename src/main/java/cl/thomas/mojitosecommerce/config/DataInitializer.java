package cl.thomas.mojitosecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import cl.thomas.mojitosecommerce.entity.Role;
import cl.thomas.mojitosecommerce.entity.Usuario;
import cl.thomas.mojitosecommerce.repository.RoleRepository;
import cl.thomas.mojitosecommerce.repository.UsuarioRepository;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        
        // 1. ASEGURAR QUE EXISTAN LOS ROLES EN LA BD
        if (roleRepository.findByNombre("ROLE_USER").isEmpty()) {
            Role userRole = new Role();
            userRole.setNombre("ROLE_USER");
            roleRepository.save(userRole);
        }

        if (roleRepository.findByNombre("ROLE_ADMIN").isEmpty()) {
            Role adminRole = new Role();
            adminRole.setNombre("ROLE_ADMIN");
            roleRepository.save(adminRole);
        }

        // 2. CREACIÓN DEL ADMINISTRADOR SEBASTIAN
        String emailSebastian = "sebastian@bootcamp.cl";
        
        // Solo lo crea si NO existe ya en la base de datos
        if (usuarioRepository.findByUsername(emailSebastian).isEmpty()) {
            Usuario admin = new Usuario();
            admin.setEmail(emailSebastian);
            admin.setUsername(emailSebastian);
            // Password por defecto: admin123
            admin.setPassword(passwordEncoder.encode("admin123"));

            // Buscamos el rol ADMIN que acabamos de asegurar arriba
            Role adminRole = roleRepository.findByNombre("ROLE_ADMIN")
                .orElseThrow(() -> new RuntimeException("Error: El rol ROLE_ADMIN no existe."));
            
            // Usamos el método que agregamos a la entidad Usuario
            admin.añadirRol(adminRole);
            
            usuarioRepository.save(admin);
            System.out.println("---------------------------------------------------------");
            System.out.println(">>> ACCESO CREADO:");
            System.out.println(">>> Usuario: " + emailSebastian);
            System.out.println(">>> Password: admin123");
            System.out.println("---------------------------------------------------------");
        }
    }
}
