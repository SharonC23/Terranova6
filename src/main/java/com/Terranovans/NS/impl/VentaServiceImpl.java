package com.Terranovans.NS.impl;


import com.Terranovans.NS.dto.ventaDTO;
import com.Terranovans.NS.entity.producto;
import com.Terranovans.NS.entity.Usuario;
import com.Terranovans.NS.entity.venta;
import com.Terranovans.NS.exceptions.CustomException;
import com.Terranovans.NS.repository.VentaRepository;
import com.Terranovans.NS.repository.ProductoRepository;
import com.Terranovans.NS.repository.UsuarioRepository;
import com.Terranovans.NS.service.VentaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements VentaService {

    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;
    private final VentaRepository ventaRepository;
    private final ModelMapper modelMapper;

    public VentaServiceImpl(ProductoRepository productoRepository, UsuarioRepository usuarioRepository, VentaRepository ventaRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.usuarioRepository = usuarioRepository;
        this.ventaRepository = ventaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ventaDTO> getAllVenta() {
        return ventaRepository.findAll()
                .stream()
                .map(venta -> {
                    ventaDTO dto = new ventaDTO();
                    dto.setIdVenta(venta.getIdVenta());
                    dto.setFechaVenta(venta.getFechaVenta());
                    dto.setEstado(venta.getEstado());
                    dto.setNota(venta.getNota());
                    dto.setMetodoPago(venta.getMetodoPago());
                    dto.setGananciaNeta(venta.getGananciaNeta());

                    // Solo asignar IDs de relaciones, no el objeto completo
                    if (venta.getIdProducto() != null) {
                        dto.setIdProducto(venta.getIdProducto().getIdProducto());
                    }

                    if (venta.getCedula() != null) {
                        dto.setCedula(venta.getCedula().getCedula());
                    }

                    return dto;
                })
                .collect(Collectors.toList());
    }


    @Override
    public ventaDTO createVenta(ventaDTO ventaDTO) {
        venta venta = new venta();

        venta.setFechaVenta(ventaDTO.getFechaVenta());
        venta.setEstado(ventaDTO.getEstado());
        venta.setNota(ventaDTO.getNota());
        venta.setMetodoPago(ventaDTO.getMetodoPago());
        venta.setGananciaNeta(ventaDTO.getGananciaNeta());

        // Producto
        if (ventaDTO.getIdProducto() != null) {
            producto producto = productoRepository.findById(ventaDTO.getIdProducto())
                    .orElseThrow(() -> new CustomException("Producto no encontrado"));
            venta.setIdProducto(producto);
        } else {
            throw new CustomException("idProducto es obligatorio");
        }

        // Usuario
        if (ventaDTO.getCedula() != null) {
            Usuario usuario = usuarioRepository.findById(ventaDTO.getCedula())
                    .orElseThrow(() -> new CustomException("Usuario no encontrado"));
            venta.setCedula(usuario);
        } else {
            throw new CustomException("Cedula de usuario es obligatoria");
        }

        venta = ventaRepository.save(venta);

        ventaDTO resultDTO = new  ventaDTO();
        resultDTO.setIdVenta(venta.getIdVenta());
        resultDTO.setFechaVenta(venta.getFechaVenta());
        resultDTO.setEstado(venta.getEstado());
        resultDTO.setNota(venta.getNota());
        resultDTO.setMetodoPago(venta.getMetodoPago());
        resultDTO.setGananciaNeta(venta.getGananciaNeta());
        resultDTO.setIdProducto(venta.getIdProducto().getIdProducto());
        resultDTO.setCedula(venta.getCedula().getCedula());
        return resultDTO;
    }

    @Override
    public ventaDTO getVentaById(Long idVenta) {
        venta venta = ventaRepository.findById(idVenta)
                .orElseThrow(() -> new CustomException("Venta no encontrada con id: " + idVenta));
        return modelMapper.map(venta, ventaDTO.class);
    }

    @Override
    public ventaDTO updateVenta(Long id, ventaDTO ventaDTO) {
        venta ventaEntity = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        ventaEntity.setEstado(ventaDTO.getEstado());
        ventaEntity.setFechaVenta(ventaDTO.getFechaVenta());
        ventaEntity.setGananciaNeta(ventaDTO.getGananciaNeta());
        ventaEntity.setMetodoPago(ventaDTO.getMetodoPago());
        ventaEntity.setNota(ventaDTO.getNota());

        // Relación con producto
        producto producto = productoRepository.findById(ventaDTO.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        ventaEntity.setIdProducto(producto);

        // Relación con usuario
        Usuario user = usuarioRepository.findById(ventaDTO.getCedula())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        ventaEntity.setCedula(user);

        ventaRepository.save(ventaEntity);

        // Mapear a DTO manualmente
        ventaDTO resultDTO = new ventaDTO();
        resultDTO.setIdVenta(ventaEntity.getIdVenta());
        resultDTO.setEstado(ventaEntity.getEstado());
        resultDTO.setFechaVenta(ventaEntity.getFechaVenta());
        resultDTO.setGananciaNeta(ventaEntity.getGananciaNeta());
        resultDTO.setMetodoPago(ventaEntity.getMetodoPago());
        resultDTO.setNota(ventaEntity.getNota());
        resultDTO.setIdProducto(producto.getIdProducto());
        resultDTO.setCedula(user.getCedula());

        return resultDTO;
    }


    @Override
    public boolean deleteVenta(Long idVenta) {
        if (!ventaRepository.existsById(idVenta)) {
            throw new CustomException("Venta no encontrada con id: " + idVenta);
        }
        ventaRepository.deleteById(idVenta);
        return true;
    }
}
