package com.Terranovans.NS.controller;


import com.Terranovans.NS.dto.citaDTO;
import com.Terranovans.NS.service.citaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@RequiredArgsConstructor
public class citaController {

    private final citaService citaService;

    @PostMapping
    public citaDTO crear(@RequestBody citaDTO dto) {
        return citaService.crearCita(dto);
    }

    @GetMapping
    public List<citaDTO> listar() {
        return citaService.listarCitas();
    }

    @GetMapping("/{id}")
    public citaDTO obtener(@PathVariable Long id) {
        return citaService.obtenerCitaPorId(id);
    }

    @PutMapping("/{id}")
    public citaDTO actualizar(@PathVariable Long id, @RequestBody citaDTO dto) {
        return citaService.actualizarCita(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        citaService.eliminarCita(id);
    }
}


