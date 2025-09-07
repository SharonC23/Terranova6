package com.Terranovans.NS.controller;


import com.Terranovans.NS.dto.ganadoDTO;
import com.Terranovans.NS.dto.imagenDTO;
import com.Terranovans.NS.repository.imagenRepository;
import com.Terranovans.NS.service.imagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/imagenes")
public class imagenController {

    @Autowired
    private imagenRepository imagenRepository;
    private final imagenService imagenService;

    public imagenController(com.Terranovans.NS.service.imagenService imagenService) {
        this.imagenService = imagenService;
    }

    @PostMapping("/create")
    public ResponseEntity<imagenDTO> createImagen(@Validated @RequestBody imagenDTO imagenDTO){
        imagenService.createImagen(imagenDTO);
        return ResponseEntity.ok(imagenDTO);
    }

    @PutMapping("/update/{idImagen}")
    public ResponseEntity<imagenDTO> updateImagen(@PathVariable Long idImagen, @RequestBody imagenDTO imagenDTO){
        imagenDTO imagen = imagenService.updatedImagen(idImagen, imagenDTO);
        return ResponseEntity.ok(imagen);
    }
}
