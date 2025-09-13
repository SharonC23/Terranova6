package com.Terranovans.NS.controller;


import com.Terranovans.NS.dto.imagenDTO;
import com.Terranovans.NS.repository.ImagenRepository;
import com.Terranovans.NS.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/imagenes")
public class ImagenController {

    @Autowired
    private ImagenRepository imagenRepository;
    private final ImagenService imagenService;

    public ImagenController(ImagenService imagenService) {
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
