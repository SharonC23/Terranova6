package com.Terranovans.NS.impl;

import com.Terranovans.NS.dto.fincaDTO;
import com.Terranovans.NS.entity.finca;
import com.Terranovans.NS.entity.producto;
import com.Terranovans.NS.repository.fincaRepository;
import com.Terranovans.NS.repository.productoRepository;
import com.Terranovans.NS.service.fincaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class fincaServiceImpl implements fincaService {

    @Autowired
    private fincaRepository fincaRepo;

    @Autowired
    private productoRepository productoRepo;

    @Override
    public fincaDTO crear(fincaDTO dto) {
        producto prod = productoRepo.findById(dto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        finca f = mapearEntidad(dto, prod);
        return mapearDTO(fincaRepo.save(f));
    }

    @Override
    public List<fincaDTO> listar() {
        return fincaRepo.findAll().stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public fincaDTO obtenerPorId(Long id) {
        finca f = fincaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Finca no encontrada"));
        return mapearDTO(f);
    }

    @Override
    public fincaDTO actualizar(Long id, fincaDTO dto) {
        finca f = fincaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Finca no encontrada"));

        producto prod = productoRepo.findById(dto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        f.setEspacioTotal(dto.getEspacioTotal());
        f.setEspacioConstruido(dto.getEspacioConstruido());
        f.setEspacioDisponible(dto.getEspacioDisponible());
        f.setEstrato(dto.getEstrato());
        f.setNumeroHabitaciones(dto.getNumeroHabitaciones());
        f.setNumeroBanos(dto.getNumeroBanos());
        f.setIdProducto(prod);

        return mapearDTO(fincaRepo.save(f));
    }

    @Override
    public void eliminar(Long id) {
        finca f = fincaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Finca no encontrada"));
        fincaRepo.delete(f);
    }

    private fincaDTO mapearDTO(finca f) {
        fincaDTO dto = new fincaDTO();
        dto.setIdFinca(f.getIdFinca());
        dto.setEspacioTotal(f.getEspacioTotal());
        dto.setEspacioConstruido(f.getEspacioConstruido());
        dto.setEspacioDisponible(f.getEspacioDisponible());
        dto.setEstrato(f.getEstrato());
        dto.setNumeroHabitaciones(f.getNumeroHabitaciones());
        dto.setNumeroBanos(f.getNumeroBanos());
        dto.setIdProducto(f.getIdProducto().getIdProducto());
        return dto;
    }

    private finca mapearEntidad(fincaDTO dto, producto prod) {
        finca f = new finca();
        f.setEspacioTotal(dto.getEspacioTotal());
        f.setEspacioConstruido(dto.getEspacioConstruido());
        f.setEspacioDisponible(dto.getEspacioDisponible());
        f.setEstrato(dto.getEstrato());
        f.setNumeroHabitaciones(dto.getNumeroHabitaciones());
        f.setNumeroBanos(dto.getNumeroBanos());
        f.setIdProducto(prod);
        return f;
    }
}
