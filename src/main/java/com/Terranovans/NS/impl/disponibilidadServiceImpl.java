package com.Terranovans.NS.impl;



import com.Terranovans.NS.dto.disponibilidadDTO;
import com.Terranovans.NS.entity.calendario;
import com.Terranovans.NS.entity.disponibilidad;
import com.Terranovans.NS.repository.CalendarioRepository;
import com.Terranovans.NS.repository.disponibilidadRepository;
import com.Terranovans.NS.service.disponibilidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class disponibilidadServiceImpl implements disponibilidadService {

    private final disponibilidadRepository disponibilidadRepo;
    private final CalendarioRepository calendarioRepo;

    @Override
    public disponibilidadDTO crearDisponibilidad(disponibilidadDTO dto) {
        return mapToDTO(disponibilidadRepo.save(mapToEntity(dto)));
    }

    @Override
    public List<disponibilidadDTO> obtenerDisponibilidades() {
        return disponibilidadRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public disponibilidadDTO obtenerPorId(Long id) {
        disponibilidad d = disponibilidadRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Disponibilidad no encontrada"));
        return mapToDTO(d);
    }

    @Override
    public disponibilidadDTO actualizarDisponibilidad(Long id, disponibilidadDTO dto) {
        disponibilidad d = disponibilidadRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Disponibilidad no encontrada"));

        d.setFecha(dto.getFecha());
        d.setHora(dto.getHora());
        d.setDisponible(dto.getDisponible());

        if (dto.getIdCalendario() != null) {
            calendario cal = calendarioRepo.findById(dto.getIdCalendario())
                    .orElseThrow(() -> new RuntimeException("Calendario no encontrado"));
            d.setCalendario(cal);
        }

        return mapToDTO(disponibilidadRepo.save(d));
    }

    @Override
    public void eliminarDisponibilidad(Long id) {
        disponibilidad d = disponibilidadRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Disponibilidad no encontrada"));
        disponibilidadRepo.delete(d);
    }

    // Métodos auxiliares
    private disponibilidadDTO mapToDTO(disponibilidad d) {
        disponibilidadDTO dto = new disponibilidadDTO();
        dto.setIdDisponibilidad(d.getIdDisponibilidad());
        dto.setFecha(d.getFecha());
        dto.setHora(d.getHora());
        dto.setDisponible(d.getDisponible());
        dto.setIdCalendario(d.getCalendario().getIdCalendario());
        return dto;
    }

    private disponibilidad mapToEntity(disponibilidadDTO dto) {
        disponibilidad d = new disponibilidad();
        d.setFecha(dto.getFecha());
        d.setHora(dto.getHora());
        d.setDisponible(dto.getDisponible());
        d.setCalendario(calendarioRepo.findById(dto.getIdCalendario())
                .orElseThrow(() -> new RuntimeException("Calendario no encontrado")));
        return d;
    }
}
