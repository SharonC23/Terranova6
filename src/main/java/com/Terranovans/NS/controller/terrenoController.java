package com.Terranovans.NS.controller;


import com.Terranovans.NS.dto.terrenoDTO;
import com.Terranovans.NS.repository.terrenoRepository;
import com.Terranovans.NS.service.terrenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/terrenos")
public class terrenoController {

    @Autowired
    private terrenoRepository terrenoRepository;
    private final terrenoService terrenoService;

    public terrenoController(com.Terranovans.NS.service.terrenoService terrenoService) {
        this.terrenoService = terrenoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<terrenoDTO>> getAllTerreno(){
        List<terrenoDTO> terrenos = terrenoService.getAllTerreno();
        return ResponseEntity.ok(terrenos);
    }

    @PostMapping("/create")
    public ResponseEntity<terrenoDTO> createTerreno(@Validated @RequestBody terrenoDTO terrenoDTO){
        terrenoService.createTerreno(terrenoDTO);
        return ResponseEntity.ok(terrenoDTO);
    }

    @PutMapping("/update/{idTerreno}")
    public ResponseEntity<terrenoDTO> updateTerreno(@PathVariable Long idTerreno, @RequestBody terrenoDTO terrenoDTO){
        terrenoDTO terreno = terrenoService.updateTerreno(idTerreno, terrenoDTO);
        return ResponseEntity.ok(terreno);
    }

    @DeleteMapping("/delete/{idTerreno}")
    public ResponseEntity<Void> deleteTerreno(@PathVariable Long idTerreno){
        terrenoService.deleteTerreno(idTerreno);
        return ResponseEntity.noContent().build();
    }
}

