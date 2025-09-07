package com.Terranovans.NS.controller;


import com.Terranovans.NS.dto.notificacionDTO;
import com.Terranovans.NS.service.notificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class notificacionController {

    private final notificacionService notificacionService;

    public notificacionController(com.Terranovans.NS.service.notificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<notificacionDTO>> getAllNotificacion(){
        List<notificacionDTO> notificaciones = notificacionService.getAllNotificacion();
        return ResponseEntity.ok(notificaciones);
    }

    @PostMapping("/create")
    public ResponseEntity<notificacionDTO> create(@RequestBody notificacionDTO notificacionDTO) {
        notificacionService.createNotificacion((notificacionDTO));
        return ResponseEntity.ok(notificacionDTO);
    }


}
