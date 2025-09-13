package com.Terranovans.NS.impl;

import com.Terranovans.NS.dto.ProductoDTO;
import com.Terranovans.NS.entity.producto;
import com.Terranovans.NS.entity.Usuario;
import com.Terranovans.NS.exceptions.CustomException;
import com.Terranovans.NS.repository.ProductoRepository;
import com.Terranovans.NS.repository.UsuarioRepository;
import com.Terranovans.NS.service.ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    public ProductoServiceImpl(ProductoRepository productoRepository, UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductoDTO> getAllProducts() {
        List<producto> productos = productoRepository.findAll();
        return productos.stream().map(producto -> modelMapper.map(producto, ProductoDTO.class))
                .toList();

    }

    @Override
    public ProductoDTO createProduct(ProductoDTO productoDTO) {
        producto producto = modelMapper.map(productoDTO, com.Terranovans.NS.entity.producto.class);

        // Si viene un usuario asociado
        if (productoDTO.getCedula() != null) {
            Usuario usuario = usuarioRepository.findById(productoDTO.getCedula())
                    .orElseThrow(() -> new CustomException("Usuario no encontrado con cédula: " + productoDTO.getCedula()));
            producto.setCedula(usuario);
        }

        producto = productoRepository.save(producto);
        return modelMapper.map(producto, ProductoDTO.class);
    }



    @Override
    public ProductoDTO getProductById(Long idProducto) {
        return null;
    }

    @Override
    public ProductoDTO updateProduct(Long idProducto, ProductoDTO productoDTO) {
        if (productoRepository.existsById(idProducto)) {
            producto producto = modelMapper.map(productoDTO, producto.class);
            producto.setIdProducto(idProducto);
            producto = productoRepository.save(producto);
            return modelMapper.map(producto, ProductoDTO.class);
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
