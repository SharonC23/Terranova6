package com.Terranovans.NS.impl;


import com.Terranovans.NS.dto.ganadoDTO;
import com.Terranovans.NS.entity.ganado;
import com.Terranovans.NS.entity.producto;
import com.Terranovans.NS.exceptions.CustomException;
import com.Terranovans.NS.repository.ganadoRepository;
import com.Terranovans.NS.repository.productoRepository;
import com.Terranovans.NS.service.ganadoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ganadoServiceImpl implements ganadoService {

    private final productoRepository productoRepository;
    private final ganadoRepository ganadoRepository;
    private final ModelMapper modelMapper;


    public ganadoServiceImpl(com.Terranovans.NS.repository.productoRepository productoRepository, com.Terranovans.NS.repository.ganadoRepository ganadoRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.ganadoRepository = ganadoRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<ganadoDTO> getAllGanado() {
        List<ganado> entities = ganadoRepository.findAll();
        return entities.stream()
                .map(entity -> modelMapper.map(entity, ganadoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ganadoDTO createGanado(ganadoDTO ganadoDTO) {
        ganado ganado = modelMapper.map(ganadoDTO, com.Terranovans.NS.entity.ganado.class);
        if (ganadoDTO.getIdproducto() != null) {
            producto producto = productoRepository.findById(ganadoDTO.getIdproducto())
                    .orElseThrow(() -> new CustomException("Producto no encontrado"));
            ganado.setIdProducto(producto);
        }

        ganado = ganadoRepository.save(ganado);
        return modelMapper.map(ganado, ganadoDTO.class);
    }

    @Override
    public ganadoDTO getGanadoById(Long idGanado) {
        ganado ganado = ganadoRepository.findById(idGanado)
                .orElseThrow(() -> new CustomException("Ganado no encontrado con id: " + idGanado));
        return modelMapper.map(ganado, ganadoDTO.class);
    }

    @Override
    public ganadoDTO updateGanado(Long idGanado, ganadoDTO ganadoDTO) {
        if (!ganadoRepository.existsById(idGanado)) {
            throw new CustomException("Ganado no encontrado con id: " + idGanado);
        }
        ganado ganado = modelMapper.map(ganadoDTO, ganado.class);
        ganado.setIdGanado(idGanado);

        if (ganadoDTO.getIdproducto() != null) {
            producto prod = productoRepository.findById(ganadoDTO.getIdproducto())
                    .orElseThrow(() -> new CustomException("Producto no encontrado con id: " + ganadoDTO.getIdproducto()));
            ganado.setIdProducto(prod);
        }

        ganado = ganadoRepository.save(ganado);
        return modelMapper.map(ganado, ganadoDTO.class);
    }

    @Override
    public boolean deleteGanado(Long idGanado) {
        if (!ganadoRepository.existsById(idGanado)) {
            throw new CustomException("Ganado no encontrado con id: " + idGanado);
        }
        ganadoRepository.deleteById(idGanado);
        return true;
    }
}
