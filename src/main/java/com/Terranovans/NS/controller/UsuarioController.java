package com.Terranovans.NS.controller;


import com.Terranovans.NS.dto.usuarioDTO;
import com.Terranovans.NS.repository.usuarioRepository;
import com.Terranovans.NS.service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.validation.Valid;
import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private usuarioRepository usuarioRepository;

    private final usuarioService usuarioService;

    public UsuarioController(usuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Página principal
    @GetMapping("/")
    public String index(Model model, Authentication authentication) {
        model.addAttribute("usuario", authentication != null ? authentication.getName() : "Invitado");
        return "index"; // index.html en templates
    }

    // Página de login
    @GetMapping("/login")
    public String login() {
        return "login"; // login.html en templates
    }

    // Página de registro
    @GetMapping("/registro")
    public String registroForm(Model model) {
        model.addAttribute("usuarioDTO", new usuarioDTO());
        return "registro"; // registro.html
    }


    // Procesar registro
    @PostMapping("/registro")
    public String registrarUsuario(@Valid @ModelAttribute usuarioDTO usuarioDTO,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "registro";
        }

        if (usuarioService.usuarioExiste(usuarioDTO.getCedula())) {
            redirectAttributes.addFlashAttribute("yaExiste", true);
            return "redirect:/registro";
        }

        usuarioService.createUser(usuarioDTO);
        redirectAttributes.addFlashAttribute("creado", true);
        return "redirect:/login";
    }


    // Dashboard para usuario logueado
    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication) {
        model.addAttribute("usuario", authentication != null ? authentication.getName() : "Invitado");
        return "dashboard"; // dashboard.html en templates
    }

    // Listar usuarios (opcional)
    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<usuarioDTO> usuarios = usuarioService.getAllUsers();
        model.addAttribute("usuarios", usuarios);
        return "usuarios"; // usuarios.html en templates
    }
}
