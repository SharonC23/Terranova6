package com.Terranovans.NS.service;


import com.Terranovans.NS.dto.ventaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ventaService {

    List<ventaDTO> getAllVenta();

    ventaDTO createVenta(ventaDTO ventaDTO);
    ventaDTO getVentaById(Long idVenta);
    ventaDTO updateVenta(Long idVenta, ventaDTO ventaDTO);
    boolean deleteVenta(Long idVenta);
}
