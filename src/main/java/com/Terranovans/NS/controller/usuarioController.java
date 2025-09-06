package com.Terranovans.NS.controller;


import com.Terranovans.NS.dto.usuarioDTO;
import com.Terranovans.NS.repository.usuarioRepository;
import com.Terranovans.NS.service.usuarioService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/usuarios")
public class usuarioController {

    @Autowired
    private usuarioRepository usuarioRepository;

    private final usuarioService usuarioService;
    public usuarioController(com.Terranovans.NS.service.usuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<usuarioDTO>> getAllUsers() {
        List<usuarioDTO> usuarios = usuarioService.getAllUsers();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/create")
    public ResponseEntity<usuarioDTO> createUsuario(@Validated @RequestBody usuarioDTO usuarioDTO){
        usuarioService.createUser(usuarioDTO);
        return ResponseEntity.ok(usuarioDTO);
    }

    @PutMapping("/update/{cedula}")
    public ResponseEntity<usuarioDTO> updateUsuario(@PathVariable Long cedula, @RequestBody usuarioDTO usuarioDTO) {
        usuarioService.updateUser(cedula, usuarioDTO);
        return ResponseEntity.ok(usuarioDTO);
    }

    @DeleteMapping("/delete/{cedula}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long cedula) {
        usuarioService.deleteUser(cedula);
        return ResponseEntity.noContent().build();
    }
}

