package com.Terranovans.NS.impl;


import com.Terranovans.NS.dto.citaDTO;
import com.Terranovans.NS.entity.cita;
import com.Terranovans.NS.entity.disponibilidad;
import com.Terranovans.NS.entity.producto;
import com.Terranovans.NS.entity.Usuario;
import com.Terranovans.NS.repository.CitaRepository;
import com.Terranovans.NS.repository.DisponibilidadRepository;
import com.Terranovans.NS.repository.ProductoRepository;
import com.Terranovans.NS.repository.UsuarioRepository;
import com.Terranovans.NS.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepo;
    private final DisponibilidadRepository disponibilidadRepo;
    private final ProductoRepository productoRepo;
    private final UsuarioRepository usuarioRepo;

    @Override
    public citaDTO crearCita(citaDTO dto) {
        return mapToDTO(citaRepo.save(mapToEntity(dto)));
    }

    @Override
    public List<citaDTO> listarCitas() {
        return citaRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public citaDTO obtenerCitaPorId(Long id) {
        cita cita = citaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        return mapToDTO(cita);
    }

    @Override
    public citaDTO actualizarCita(Long id, citaDTO dto) {
        cita cita = citaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        cita.setFechaCita(dto.getFechaCita());
        cita.setEstadoCita(dto.getEstadoCita());
        cita.setUbicacionCita(dto.getUbicacionCita());
        cita.setHoraCita(dto.getHoraCita());

        if (dto.getIdDisponibilidad() != null) {
            disponibilidad disp = disponibilidadRepo.findById(dto.getIdDisponibilidad())
                    .orElseThrow(() -> new RuntimeException("Disponibilidad no encontrada"));
            cita.setIdDisponibilidad(disp);
        }

        if (dto.getIdProducto() != null) {
            producto prod = productoRepo.findById(dto.getIdProducto())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            cita.setIdProducto(prod);
        }

        if (dto.getCedula() != null) {
            Usuario usuario = usuarioRepo.findById(dto.getCedula())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            cita.setCedula(usuario);
        }

        return mapToDTO(citaRepo.save(cita));
    }

    @Override
    public void eliminarCita(Long id) {
        cita cita = citaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        citaRepo.delete(cita);
    }

    // ----------------- Métodos auxiliares -----------------
    private citaDTO mapToDTO(cita cita) {
        citaDTO dto = new citaDTO();
        dto.setIdCita(cita.getIdCita());
        dto.setFechaCita(cita.getFechaCita());
        dto.setEstadoCita(cita.getEstadoCita());
        dto.setUbicacionCita(cita.getUbicacionCita());
        dto.setHoraCita(cita.getHoraCita());
        dto.setIdDisponibilidad(cita.getIdDisponibilidad().getIdDisponibilidad());
        dto.setIdProducto(cita.getIdProducto().getIdProducto());
        dto.setCedula(cita.getCedula().getCedula());
        return dto;
    }

    private cita mapToEntity(citaDTO dto) {
        cita cita = new cita();
        cita.setFechaCita(dto.getFechaCita());
        cita.setEstadoCita(dto.getEstadoCita());
        cita.setUbicacionCita(dto.getUbicacionCita());
        cita.setHoraCita(dto.getHoraCita());

        cita.setIdDisponibilidad(disponibilidadRepo.findById(dto.getIdDisponibilidad())
                .orElseThrow(() -> new RuntimeException("Disponibilidad no encontrada")));

        cita.setIdProducto(productoRepo.findById(dto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado")));

        cita.setCedula(usuarioRepo.findById(dto.getCedula())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

        return cita;
    }
}
