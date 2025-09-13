package com.Terranovans.NS.service;


import com.Terranovans.NS.dto.citaDTO;
import java.util.List;

public interface CitaService {
    citaDTO crearCita(citaDTO dto);
    List<citaDTO> listarCitas();
    citaDTO obtenerCitaPorId(Long id);
    citaDTO actualizarCita(Long id, citaDTO dto);
    void eliminarCita(Long id);
}
