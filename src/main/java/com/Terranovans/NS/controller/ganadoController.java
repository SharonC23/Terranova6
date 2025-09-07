package com.Terranovans.NS.controller;


import com.Terranovans.NS.dto.ganadoDTO;
import com.Terranovans.NS.dto.productoDTO;
import com.Terranovans.NS.repository.ganadoRepository;
import com.Terranovans.NS.service.ganadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/ganados")
public class ganadoController {

    @Autowired
    private ganadoRepository ganadoRepository;
    private final ganadoService ganadoService;

    public ganadoController(com.Terranovans.NS.service.ganadoService ganadoService) {
        this.ganadoService = ganadoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ganadoDTO>> getAllGanado(){
        List<ganadoDTO> ganados = ganadoService.getAllGanado();
        return ResponseEntity.ok(ganados);
    }

    @PostMapping("/create")
    public ResponseEntity<ganadoDTO> createGanado(@Validated @RequestBody ganadoDTO ganadoDTO){
        ganadoService.createGanado(ganadoDTO);
        return ResponseEntity.ok(ganadoDTO);
    }

    @PutMapping("/update/{idGanado}")
    public ResponseEntity<ganadoDTO> updateGanado(@PathVariable Long idGanado, @RequestBody ganadoDTO ganadoDTO) {
        ganadoDTO ganado = ganadoService.updateGanado(idGanado, ganadoDTO);
        return ResponseEntity.ok(ganado);
    }

    @DeleteMapping("/delete/{idGanado}")
    public ResponseEntity<Void> deleteGanado(@PathVariable Long idGanado) {
        ganadoService.deleteGanado(idGanado);
        return ResponseEntity.noContent().build();
    }

}
