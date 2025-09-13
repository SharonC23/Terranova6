package com.Terranovans.NS.controller;


import com.Terranovans.NS.dto.ventaDTO;
import com.Terranovans.NS.repository.VentaRepository;
import com.Terranovans.NS.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaRepository ventaRepository;
    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping("/all")
    public  ResponseEntity<List<ventaDTO>> getAllVenta(){
        List<ventaDTO> ventas = ventaService.getAllVenta();
        return ResponseEntity.ok(ventas);
    }

    @PostMapping("/create")
    public ResponseEntity<ventaDTO> createVenta(@Validated @RequestBody ventaDTO ventaDTO){
        ventaService.createVenta(ventaDTO);
        return ResponseEntity.ok(ventaDTO);
    }

    @PutMapping("/update/{idVenta}")
    public  ResponseEntity<ventaDTO> updateVenta(@PathVariable Long idVenta, @RequestBody ventaDTO ventaDTO){
        ventaDTO venta = ventaService.updateVenta(idVenta, ventaDTO);
        return ResponseEntity.ok(venta);
    }

    @DeleteMapping("/delete/{idVenta}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Long idVenta){
        ventaService.deleteVenta(idVenta);
        return  ResponseEntity.noContent().build();
    }
}
