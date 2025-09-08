package com.Terranovans.NS.controller;


import com.Terranovans.NS.dto.fincaDTO;
import com.Terranovans.NS.service.fincaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fincas")
public class fincaController {

    @Autowired
    private fincaService fincaServ;

    @PostMapping
    public fincaDTO crear(@RequestBody fincaDTO dto) {
        return fincaServ.crear(dto);
    }

    @GetMapping
    public List<fincaDTO> listar() {
        return fincaServ.listar();
    }

    @GetMapping("/{id}")
    public fincaDTO obtenerPorId(@PathVariable Long id) {
        return fincaServ.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public fincaDTO actualizar(@PathVariable Long id, @RequestBody fincaDTO dto) {
        return fincaServ.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        fincaServ.eliminar(id);
    }
}
