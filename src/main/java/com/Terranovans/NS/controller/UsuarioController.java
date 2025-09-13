package com.Terranovans.NS.controller;


import com.Terranovans.NS.dto.ProductoDTO;
import com.Terranovans.NS.dto.usuarioDTO;
import com.Terranovans.NS.entity.Usuario;
import com.Terranovans.NS.repository.UsuarioRepository;
import com.Terranovans.NS.service.ProductoService;
import com.Terranovans.NS.service.UsuarioService;
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
    private UsuarioRepository usuarioRepository;

    private final UsuarioService usuarioService;
    private final ProductoService productoService;

    public UsuarioController(UsuarioService usuarioService, ProductoService productoService) {
        this.usuarioService = usuarioService;
        this.productoService = productoService;
    }

    // Página principal
    @GetMapping("/usuarios/index")
    public String indexUsuarios(Model model, Authentication authentication) {
        // ✅ obtener el email del usuario autenticado
        String email = authentication.getName();

        // ✅ cargar el usuario desde la BD
        Usuario usuario = usuarioService.findByEmail(email);

        // ✅ obtener lista de productos disponibles
        List<ProductoDTO> productos = ProductoService.findAllDTO();

        // ✅ agregar atributos al modelo
        model.addAttribute("usuario", usuario);
        model.addAttribute("listaProductos", productos);
        model.addAttribute("puedeComprar", true);
        model.addAttribute("puedeVender", true);

        // ✅ redirigir a la vista index
        return "usuarios/index";
    }

    @GetMapping("/user/dashboard")
    public String dashboard() {
        return "user/dashboard"; // 👈 apunta a la plantilla user/dashboard.html
    }

    // Página de login
    @GetMapping("/login")
    public String login() {
        return "login"; // busca templates/login.html
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
