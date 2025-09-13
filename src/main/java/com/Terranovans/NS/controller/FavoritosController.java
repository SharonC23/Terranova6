package com.Terranovans.NS.controller;


import com.Terranovans.NS.dto.favoritosDTO;
import com.Terranovans.NS.service.FavoritosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
@RequiredArgsConstructor
public class FavoritosController {

    private final FavoritosService favoritosService;

    @PostMapping
    public favoritosDTO crear(@RequestBody favoritosDTO favoritosDTO) {
        return favoritosService.crear(favoritosDTO);
    }

    @GetMapping
    public List<favoritosDTO> listar() {
        return favoritosService.listar();
    }

    @GetMapping("/{id}")
    public favoritosDTO obtenerPorId(@PathVariable Long id) {
        return favoritosService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public favoritosDTO actualizar(@PathVariable Long id, @RequestBody favoritosDTO favoritosDTO) {
        return favoritosService.actualizar(id, favoritosDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        favoritosService.eliminar(id);
    }
}
