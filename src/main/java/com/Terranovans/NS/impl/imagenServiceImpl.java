package com.Terranovans.NS.impl;

import com.Terranovans.NS.dto.imagenDTO;
import com.Terranovans.NS.entity.imagen;
import com.Terranovans.NS.entity.producto;
import com.Terranovans.NS.repository.imagenRepository;
import com.Terranovans.NS.repository.productoRepository;
import com.Terranovans.NS.service.imagenService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class imagenServiceImpl implements imagenService {

    private final imagenRepository imagenRepository;
    private final productoRepository productoRepository;
    private final ModelMapper modelMapper;

    public imagenServiceImpl(com.Terranovans.NS.repository.imagenRepository imagenRepository, com.Terranovans.NS.repository.productoRepository productoRepository, ModelMapper modelMapper) {
        this.imagenRepository = imagenRepository;
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<imagenDTO> getAllImagen() {
        return imagenRepository.findAll()
                .stream()
                .map(imagen -> modelMapper.map(imagen, imagenDTO.class))
                .collect(Collectors.toList());
    }



    @Override
    public imagenDTO createImagen(imagenDTO dto) {
        imagen entity = new imagen();
        entity.setNombreArchivo(dto.getNombreArchivo());

        // Obtener el producto asociado
        producto prod = productoRepository.findById(dto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        entity.setIdProducto(prod);

        imagenRepository.save(entity);

        // Mapear a DTO
        imagenDTO result = new imagenDTO();
        result.setIdImagen(entity.getIdImagen());
        result.setNombreArchivo(entity.getNombreArchivo());
        result.setIdProducto(prod.getIdProducto());

        return result;
    }
    @Override
    public imagenDTO updatedImagen(Long idImagen, imagenDTO dto) {
        if (dto.getIdImagen() == null) {
            throw new IllegalArgumentException("El ID de la imagen no puede ser nulo para actualizar");
        }

        // Buscar la imagen existente
        imagen existingImagen = imagenRepository.findById(dto.getIdImagen())
                .orElseThrow(() -> new RuntimeException("Imagen no encontrada con ID " + dto.getIdImagen()));

        // Actualizar los campos
        existingImagen.setNombreArchivo(dto.getNombreArchivo());

        // Si el DTO trae un nuevo producto asociado, actualizarlo
        if (dto.getIdProducto() != null) {
            producto prod = productoRepository.findById(dto.getIdProducto())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID " + dto.getIdProducto()));
            existingImagen.setIdProducto(prod);
        }

        // Guardar la entidad actualizada
        imagenRepository.save(existingImagen);

        // Mapear a DTO
        imagenDTO result = new imagenDTO();
        result.setIdImagen(existingImagen.getIdImagen());
        result.setNombreArchivo(existingImagen.getNombreArchivo());
        result.setIdProducto(existingImagen.getIdProducto().getIdProducto());

        return result;
    }



    @Override
    public imagenDTO getImagenById(imagenDTO imagenDTO) {
        if (imagenDTO.getIdImagen() == null) {
            throw new IllegalArgumentException("El ID de la imagen no puede ser nulo");
        }

        imagen imagen = imagenRepository.findById(imagenDTO.getIdImagen())
                .orElseThrow(() -> new RuntimeException("Imagen no encontrada con ID " + imagenDTO.getIdImagen()));

        return modelMapper.map(imagen, imagenDTO.class);
    }

    @Override
    public boolean deleteImagen(imagenDTO imagenDTO) {
        if (imagenDTO.getIdImagen() == null) {
            throw new IllegalArgumentException("El ID de la imagen no puede ser nulo para eliminar");
        }

        if (!imagenRepository.existsById(imagenDTO.getIdImagen())) {
            return false;
        }

        imagenRepository.deleteById(imagenDTO.getIdImagen());
        return true;
    }
}
