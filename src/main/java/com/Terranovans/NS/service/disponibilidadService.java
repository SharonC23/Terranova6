package com.Terranovans.NS.service;



import com.Terranovans.NS.dto.disponibilidadDTO;
import java.util.List;

public interface disponibilidadService {
    disponibilidadDTO crearDisponibilidad(disponibilidadDTO dto);
    List<disponibilidadDTO> obtenerDisponibilidades();
    disponibilidadDTO obtenerPorId(Long id);
    disponibilidadDTO actualizarDisponibilidad(Long id, disponibilidadDTO dto);
    void eliminarDisponibilidad(Long id);
}
