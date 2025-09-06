package com.Terranovans.NS.impl;

import com.Terranovans.NS.dto.productoDTO;
import com.Terranovans.NS.entity.producto;
import com.Terranovans.NS.entity.usuario;
import com.Terranovans.NS.exceptions.CustomException;
import com.Terranovans.NS.repository.productoRepository;
import com.Terranovans.NS.repository.usuarioRepository;
import com.Terranovans.NS.service.ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productoServiceImpl implements ProductoService {

    private final productoRepository productoRepository;
    private final usuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    public productoServiceImpl(com.Terranovans.NS.repository.productoRepository productoRepository, com.Terranovans.NS.repository.usuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<productoDTO> getAllProducts() {
        List<producto> productos = productoRepository.findAll();
        return productos.stream().map(producto -> modelMapper.map(producto, productoDTO.class))
                .toList();

    }

    @Override
    public productoDTO createProduct(productoDTO productoDTO) {
        producto producto = modelMapper.map(productoDTO, com.Terranovans.NS.entity.producto.class);

        // Si viene un usuario asociado
        if (productoDTO.getCedula() != null) {
            usuario usuario = usuarioRepository.findById(productoDTO.getCedula())
                    .orElseThrow(() -> new CustomException("Usuario no encontrado con cédula: " + productoDTO.getCedula()));
            producto.setCedula(usuario);
        }

        producto = productoRepository.save(producto);
        return modelMapper.map(producto, productoDTO.class);
    }



    @Override
    public productoDTO getProductById(Long idProducto) {
        return null;
    }

    @Override
    public productoDTO updateProduct(Long idProducto, productoDTO productoDTO) {
        if (productoRepository.existsById(idProducto)) {
            producto producto = modelMapper.map(productoDTO, producto.class);
            producto.setIdProducto(idProducto);
            producto = productoRepository.save(producto);
            return modelMapper.map(producto, productoDTO.class);
        } else {
            throw new CustomException("Producto no encontrado con id: " + idProducto);
        }
    }

    @Override
    public boolean deleteProduct(Long idProducto) {
        if (productoRepository.existsById(idProducto)) {
            productoRepository.deleteById(idProducto);
            return true;
        } else {
            throw new CustomException("Producto no encontrado con id: " + idProducto);
        }
    }
}
