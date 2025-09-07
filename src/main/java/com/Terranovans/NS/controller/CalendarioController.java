package com.Terranovans.NS.controller;

import com.Terranovans.NS.dto.calendarioDTO;
import com.Terranovans.NS.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calendarios")
public class CalendarioController {

    @Autowired
    private CalendarioService calendarioService;

    @PostMapping("/create")
    public calendarioDTO create(@RequestBody calendarioDTO calendarioDTO) {
        return calendarioService.createCalendario(calendarioDTO);
    }

    @GetMapping("/list")
    public List<calendarioDTO> list() {
        return calendarioService.getAllCalendarios();
    }

    @PutMapping("/update/{id}")
    public calendarioDTO update(@PathVariable Long id, @RequestBody calendarioDTO calendarioDTO) {
        return calendarioService.updateCalendario(id, calendarioDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        calendarioService.deleteCalendario(id);
    }
}
