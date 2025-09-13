package com.Terranovans.NS.controller;

import com.Terranovans.NS.dto.disponibilidadDTO;
import com.Terranovans.NS.service.DisponibilidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disponibilidades")
@RequiredArgsConstructor
public class DisponibilidadController {

    private final DisponibilidadService disponibilidadService;

    @PostMapping
    public disponibilidadDTO crear(@RequestBody disponibilidadDTO dto) {
        return disponibilidadService.crearDisponibilidad(dto);
    }

    @GetMapping
    public List<disponibilidadDTO> listar() {
        return disponibilidadService.obtenerDisponibilidades();
    }

    @GetMapping("/{id}")
    public disponibilidadDTO obtener(@PathVariable Long id) {
        return disponibilidadService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public disponibilidadDTO actualizar(@PathVariable Long id, @RequestBody disponibilidadDTO dto) {
        return disponibilidadService.actualizarDisponibilidad(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        disponibilidadService.eliminarDisponibilidad(id);
    }
}
